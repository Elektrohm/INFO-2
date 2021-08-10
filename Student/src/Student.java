// A user defined class to illustrate
public class Student {
    private double grade;
    private String name;
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    public double getGrade() {
        return this.grade;
    }
    public String getName() {
        return this.name;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
}

