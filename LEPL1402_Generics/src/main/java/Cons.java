public class Cons {
    // the item inside this list node
    public int v;
    // The next element, null if nothing
    public Cons next;


    // creates a new Cons that applies function f on all elements
    public Cons Map(F f) {
        int mappedValue = f.apply(this.v);
        Cons mappedCons = new Cons(mappedValue, null);
        if (this.next != null) {
            mappedCons.next = this.next.map(f);
        }
        return mappedCons;
    }


    // creates a new Cons with all elements that matches predicate p
    public Cons filter(P p) {
        Cons filtered_cons = new Cons(0,null);
        Cons head = this;
        while (head != null) {
            if (p.filter(head.v)) {
                filtered_cons.v = head.v;
                if (head.next != null){filtered_cons.next = head.next.filter(p);}
                return filtered_cons;
            }
            head = head.next;
        }
        return null;
    }


    public Cons filter(P p){
        Cons filtered = new Cons(this.v, null);
        if (p.filter(this.v)){filtered.v = this.v;}
        if (this.next != null){
            filtered.next = this.next.filter(p);
        }
    }
    public Cons map(F f){
        Cons mappedCons = new Cons(f.apply(this.v), null);
        Cons copy = mappedCons;
        Cons head = this.next;
        while (head!=null){
            copy.next = new Cons(f.apply(head.v),null);
            head = head.next;
            copy=copy.next;
        }
        return mappedCons;
    }

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}