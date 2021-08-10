import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Student findFirst(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
    Student[] students = findAll(studentsStream, conditions);
    if (students.length==0){
      return null;
    }
    return students[0];
  }

  public Student[] findAll(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
    if (conditions.containsKey("firstName")) {
      Predicate<String> predFirstName = (Predicate<String>) conditions.get("firstName");
      studentsStream = studentsStream.filter(s -> predFirstName.test(s.getFirstName()));
    }
    if (conditions.containsKey("lastName")) {
      Predicate<String> predLastName = (Predicate<String>) conditions.get("lastName");
      studentsStream = studentsStream.filter(s -> predLastName.test(s.getLastName()));
    }

    if (conditions.containsKey("section")) {
      Predicate<Integer> predSection = (Predicate<Integer>) conditions.get("section");
      studentsStream = studentsStream.filter(s -> predSection.test(s.getSection()));
    }

    if (conditions.containsKey("courses_results")) {
      Predicate<Map<String, Double>> predCourse = (Predicate<Map<String, Double>>) conditions.get("Courses_results");
      studentsStream = studentsStream.filter(s -> predCourse.test(s.getCourses_results()));
    }
    Student[] result = studentsStream.toArray(Student[]::new);
    return result;
  }

  public boolean exists(Stream<Student> studentsStream,
                        Map<String, Predicate<?>> conditions,
                        int n)
  {
      Student[] result = findAll(studentsStream, conditions);
      return result.length>=n;
  }

  public Student[] filterThenSort(Stream<Student> studentsStream,
                                  Map<String, Predicate<?>> conditions,
                                  Comparator<Student> comparator)
  {
    studentsStream = studentsStream.sorted(comparator);
    return findAll(studentsStream, conditions);
  }


  //=======================================================================================================//
  //Les méthodes en dessous ne devraient pas exister c'est pour des tests                                  //
  //=======================================================================================================//


  public static Student[] filterSection(Stream<Student> studentStream, int section){
    Student[] students = studentStream.filter(s->s.getSection()==section).toArray(Student[]::new);
    return students;
  }

  public static Student FindFirst(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
    Student[] students = FindAll(studentsStream, conditions);
    if (students.length==0){
      return null;
    }
    return students[0];
  }

  public static Student[] FindAll(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
    if (conditions.containsKey("firstName")) {
      Predicate<String> predFirstName = (Predicate<String>) conditions.get("firstName");
      studentsStream = studentsStream.filter(s -> predFirstName.test(s.getFirstName()));
    }
    if (conditions.containsKey("lastName")) {
      Predicate<String> predLastName = (Predicate<String>) conditions.get("lastName");
      studentsStream = studentsStream.filter(s -> predLastName.test(s.getLastName()));
    }

    if (conditions.containsKey("section")) {
      Predicate<Integer> predSection = (Predicate<Integer>) conditions.get("section");
      studentsStream = studentsStream.filter(s -> predSection.test(s.getSection()));
    }

    if (conditions.containsKey("courses_results")) {
      Predicate<Map<String, Double>> predCourse = (Predicate<Map<String, Double>>) conditions.get("Courses_results");
      studentsStream = studentsStream.filter(s -> predCourse.test(s.getCourses_results()));
    }
    Student[] result = studentsStream.toArray(Student[]::new);
    return result;
  }

  public static boolean Exists(Stream<Student> studentsStream,
                        Map<String, Predicate<?>> conditions,
                        int n)
  {
    Student[] result = FindAll(studentsStream, conditions);
    return result.length>=n;
  }

  public static Student[] FilterThenSort(Stream<Student> studentsStream,
                                  Map<String, Predicate<?>> conditions,
                                  Comparator<Student> comparator)
  {
    studentsStream = studentsStream.sorted(comparator);
    return FindAll(studentsStream, conditions);
  }


  public static void main(String args[]){

    //Conditions
    Predicate<String> predFirstName = s-> s.startsWith("T");
    Predicate<String> predLastName = s-> s.startsWith("G");
    Predicate<Integer> predSection = s-> s.equals(1);
    Predicate<Map<String,Double>> predCourse;

    //Different Map
    Map<String,Predicate<?>> condForFindFirst = new HashMap<>();
    condForFindFirst.put("firstName",predFirstName);
    condForFindFirst.put("lastName",predLastName);

    Map<String,Predicate<?>> condForFindAll = new HashMap<>();
    condForFindAll.put("firstName", predFirstName);


    Map<String,Predicate<?>> condForExist = new HashMap<>();
    condForExist.put("firstName",predFirstName);
    condForExist.put("lastName",predLastName);

    Map<String,Predicate<?>> condForExistBis = new HashMap<>();
    condForExistBis.put("firstName",predFirstName);
    condForExistBis.put("lastName",predLastName);
    condForExistBis.put("section",s->s.equals(2));


    Map<String,Predicate<?>> condForFindSort = new HashMap<>();
    condForFindSort.put("firstName",predFirstName);

    //Students
    Student theo = new Student("Theo","Denis",1,null);
    Student lucas = new Student("Lucas","Gagliano",1,null);
    Student thibault = new Student("Thibault","Gregoir",1,null);


    //Streams for different tests
    Stream<Student> studForFindFirst = Stream.of(theo,lucas,thibault);
    Stream<Student> studForFindAll = Stream.of(theo,lucas,thibault);
    Stream<Student> studForExist = Stream.of(theo,lucas,thibault);
    Stream<Student> studForExistBis = Stream.of(theo,lucas,thibault);
    Stream<Student> studForFilterSort = Stream.of(theo, lucas, thibault);

    //result of tests
    System.out.println("Test for find first should return Thibault :");
    System.out.println(FindFirst(studForFindFirst,condForFindFirst).getFirstName());

    System.out.println("Test for find all should return Thibault et Théo");
    Student[] std = FindAll(studForFindAll,condForFindAll);
    System.out.println(std[0].getFirstName() + " "+std[1].getFirstName());
    System.out.println("Il ne devrait y avoir qu'une liste de deux étudiants");
    System.out.println(Arrays.toString(std));

    System.out.println("Test for exist should return True");
    System.out.println(Exists(studForExist,condForExist,1));
    System.out.println("This one should return False");
    System.out.println(Exists(studForExistBis,condForExistBis,1));


  }
}
