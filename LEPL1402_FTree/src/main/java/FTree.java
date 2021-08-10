import java.util.function.Function;

public abstract class FTree<A> {

    public final int depth() {
        int depth = 1;
        if (this instanceof Node){
            depth += this.left().depth();
        } if (this instanceof Leaf) {
            return 0;
        }
        return depth;
    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        if (this instanceof Node) {
            B value = f.apply(this.value());
            return new Node<B>(value, this.left().map(f), this.right().map(f));
        } else{
            B value = f.apply(this.value());
            return new Leaf<>(value);
        }
    }

}
