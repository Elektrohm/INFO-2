public class Leaf implements Visitable {

    public int value;

    public Leaf(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int accept(Visitor visitor) {
        return getValue();
    }
}
