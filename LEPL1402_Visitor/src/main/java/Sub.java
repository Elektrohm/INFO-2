public class Sub extends Node implements Visitable {

    public Sub(Visitable left, Visitable right) {
        super(left, right);
    }


    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
