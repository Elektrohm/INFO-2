import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FList<A> implements Iterable<A> {

    public static <A> FList<A> nil() {
        return (Nil<A>) Nil.INSTANCE;
    }

    public final FList<A> cons(final A a) { return new Cons(a, this);}

    public abstract int length();

    public abstract boolean isEmpty();

    //NoSuchblabla si la liste est vide
    public abstract A head();

    //retourne liste sans tête et erreur si vide
    public abstract FList<A> tail();

    //retourne liste où f est appliqué
    public abstract <B> FList<B> map(Function<A,B> f);

    //retourne liste qui match condition f
    public abstract FList<A> filter(Predicate<A> f);


    public Iterator<A> iterator() {
        return new Iterator<A>() {

            private FList<A> list = FList.this;
            public boolean hasNext() {
                return list.length()>0;
            }

            public A next() {
                if(list.length()!=0){
                    A item = list.head();
                    list = list.tail();
                    return item;
                }else{
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    private static final class Nil<A> extends FList<A> {
        public static final Nil<Object> INSTANCE = new Nil();

        public int length() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        public A head() {
            throw new NoSuchElementException();
        }

        public FList<A> tail() {
            throw new NoSuchElementException();
        }

        public <B> FList<B> map(Function<A, B> f) {
            return new Nil<>();
        }

        public FList<A> filter(Predicate<A> f) {
            return new Nil<>();
        }
    }

    private static final class Cons<A> extends FList<A> {
        private A value;
        private FList<A> next;

        public Cons(A a, FList<A> as) {
            this.value = a;
            this.next = as;
        }

        public int length() {
            int length = 0;
            Cons<A> head = this;
            boolean keepLooping = true;
            while(keepLooping){
                length++;
                if (head.next.isEmpty()){keepLooping = false;}
                else{head = (Cons<A>) head.next;}
            }
            return length;
        }

        public boolean isEmpty() {
            return false;
        }

        public A head() {
            return this.value;
        }

        public FList<A> tail() {
            return this.next;
        }

        public <B> FList<B> map(Function<A, B> f) {
            B mapValue = f.apply(this.value);
            Cons<B> newFList = new Cons<B>(mapValue,FList.nil());
            newFList.next = this.next.map(f);
            return (FList<B>) newFList;
        }

        public FList<A> filter(Predicate<A> f) {
            Cons<A> filtered_cons = new Cons(this.value,FList.nil());
            Cons<A> head = this;
            boolean keepLooping = true;
            while (keepLooping) {
                if (f.test(head.value)) {
                    filtered_cons.value = head.value;
                    if (!head.next.isEmpty()){
                        filtered_cons.next = head.next.filter(f);
                    }
                    return filtered_cons;
                }
                if (!head.next.isEmpty()) {head = (Cons<A>) head.next;}
                else{ keepLooping = false; }
            }
            return FList.nil();
        }
    }

    public static void main(String args[]){
        FList<Integer> list = FList.nil();

        for (int i = 0; i < 10; i++) {
            list = list.cons(i);
        }
        list = list.map(i -> i+1);
        System.out.println(list.length());

        list = list.filter(i -> i%2==0);
        System.out.println(list.length());
    }
}