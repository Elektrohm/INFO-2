class Student{
    public final String prenom;
    public final int Noma;

    public static void main(String[] args){
        Student Theo = new Student("Theo",27411800);
        Student Philippine = new Student("Philippine",18181800);
        Student Theobis = new Student("Theo",27411800);
        System.out.println(Theo.equals(Theobis)); //true
        System.out.println(Theo.equals(Philippine)); //false
    }
    public Student(String prenom, int Noma){
            this.prenom = prenom;
            this.Noma = Noma;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Student){
            Student other = (Student) o;
            return (this.prenom == other.prenom && this.Noma == other.Noma);
        } else {
            return false;
        }
    }
}
class A {
    void foo() {
        System.out.println("foo A");
    }
}
class B extends A {
    void foo() {
        System.out.println("foo B");
    }
}
class C extends B {

}
class D extends C {
    void foo() {
        System.out.println("foo D");
    }
    void display() {
        super.foo();
    }
}
