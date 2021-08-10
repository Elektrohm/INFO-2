import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void sortPerson(ArrayList<Person> persons) {
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.name.compareTo(o2.name) > 0) return 1;
                if (o1.name.compareTo(o2.name) < 0) return -1;
                else{
                    return (o1.age - o2.age);
                }
            }
        });
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Guillaume", 20));
        persons.add(new Person("John", 50));
        persons.add(new Person("Guillaume", 10));
        persons.add(new Person("John", 10));
        persons.add(new Person("Luc", 5));

        sortPerson(persons);
        System.out.println(persons);

    }
}
