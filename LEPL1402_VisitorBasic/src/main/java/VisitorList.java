import java.util.List;

public class VisitorList extends Visitor {


    public VisitorList(Class cls) {
        super(cls);
    }

    List<Object> getFiltered() {
        for (Object element : this.filtered ){
            if (!(element.getClass().equals(this.toFilter))){
                return null;
            }
        }return this.filtered;
    }


    void visit(Visitable visitable) {
        for (Object toVisit : visitable.elements){
            this.visit(toVisit);
        }
    }


    void visit(Object o) {
        if (o.getClass().equals(Object[].class)){
            VisitableList visitable = new VisitableList((Object[]) o);
            this.visit(visitable);
        }
        if (o.getClass().equals(this.toFilter)){
            this.filtered.add(o);
        }
    }
}
