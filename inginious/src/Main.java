import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Guillaume", 20));
        persons.add(new Person("John", 50));
        persons.add(new Person("Guillaume", 10));
        persons.add(new Person("John", 10));
        persons.add(new Person("Luc", 5));

        Person.sortPerson(persons);
        System.out.println(persons);

    }
}

