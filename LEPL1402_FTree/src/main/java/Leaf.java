
public class Leaf<A> extends FTree<A> {

    private final A value;

    public Leaf(A a){
        this.value = a;
    }

    public A value() {
        return this.value;
    }

    public FTree<A> left() {
        return null;
    }

    public FTree<A> right() {
        return null;
    }
}
