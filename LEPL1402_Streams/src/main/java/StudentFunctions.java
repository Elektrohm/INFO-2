import java.util.*;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {


  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
    Stream<Student> result = studentStream
            .sorted(
                    ((Comparator<Student>) (o1,o2) -> {
              double d1 = o1.getCoursesResults().get(name);
              double d2 = o2.getCoursesResults().get(name);
              return Double.compare(d1,d2);
            }).reversed()
            ).limit(3).skip(1);
    return result;
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    Object[]  result = studentStream
            .filter((i)->(i.getSection()==section))
            .map(stud -> new Object[]{
                    String.format("%s %s %s","Student",stud.getFirstName(), stud.getLastName()),
                    stud.getCoursesResults().values().stream()
                            .reduce(0.0,(a,b)->(a+b))/(double) stud.getCoursesResults().size()
            }).toArray();
    return result;
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    Stream<Student> filtered = studentStream.filter(s -> {
      Stream<Double> successOfs = s.getCoursesResults().values().stream().filter(v -> v > 10);
      return successOfs.count() == s.getCoursesResults().size();
    });
    return (int) filtered.count();
  }


  public Student findLastInLexicographicOrder(Stream<Student> studentStream) {
    return studentStream.sorted(
            (o1, o2) -> Comparator
                    .comparing(Student::getLastName)
                    .thenComparing(Student::getFirstName)
                    .reversed().compare(o1,o2)).limit(1).findFirst().get();
  }

  public double getFullSum(Stream<Student> studentStream) {
      Double sum = studentStream.map(st -> st.getCoursesResults().
              entrySet().stream().
              map(Map.Entry::getValue).
              reduce(0.0, Double::sum)).
              reduce(0.0, Double::sum);
      return sum;
    }

}

