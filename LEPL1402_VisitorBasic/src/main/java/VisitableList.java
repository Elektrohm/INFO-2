
public class VisitableList extends Visitable {

    public VisitableList(Object[] elements){
        this.elements = elements;
    }

    void accept(Visitor visitor) {
        for (Object element : this.elements){
            visitor.visit(element);
        }
    }

    public static void main(String args[]){
        VisitableList visitable = new VisitableList(new Object[]{1,2,3,4,4.0,5.8,"hello"});
        VisitorList visitorList = new VisitorList(Integer.class);
        visitable.accept(visitorList);
        System.out.println(visitorList.getFiltered());
    }


}
