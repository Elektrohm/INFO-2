import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // the item inside this list node
    public E v;
    // The next element, null if nothing
    public Cons<E> next;


    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }

    // creates a new Cons that applies function f on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        E mapped_value = (E) function.apply(this.v);
        Cons mapped_cons = new Cons(mapped_value,null);
        if (this.next != null) {
            mapped_cons.next = this.next.map(function);
        }
        return mapped_cons;
    }

    // creates a new Cons with all elements that matches predicate p
    public Cons <E> filter(Predicate <E> predicate) {
        Cons filtered_cons = new Cons(null,null);
        Cons head = this;
        while (head != null) {
            E headValue = (E) head.v;
            if (predicate.test(headValue)) {
                filtered_cons.v = head.v;
                if (head.next != null){filtered_cons.next = head.next.filter(predicate);}
                return filtered_cons;
            }
            head = head.next;
        }
        return null;
    } 
}
