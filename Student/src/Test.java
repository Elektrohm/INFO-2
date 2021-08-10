public class Test {

    //Generic swap method
    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }

    // Common functions that illustrate external modification of a Object

    public static void setGrade(Student std) {
        std = new Student(std.getName(), std.getGrade() * 2 );
        std.setGrade( std.getGrade() * 2 );
    }

    public static void setGrade2(Student std) {
        std.setGrade(0);
    }
    // Let's see if you can correctly predict the STDOUT

    public static void main(String[] args) {

        int meanOfLife = 42;
        int randomInt = 2048;
        //le swap ne change rien car il change que dans la méthode et pas dans le main
        swap(meanOfLife, randomInt);
        String s1 = "After swapping call, MEAN OF LIFE is equal to "+ meanOfLife;
        System.out.println(s1);

        Student std = new Student("Noel", 10);
        String s_part = "Student " + std.getName() + " has the grade ";

        setGrade(std); //l'objet crée n'existe que dans sa méthode et n'impacte pas l'objet crée dans main
        String s2 = s_part + std.getGrade(); //on obtient 10 car les 40 n'existe que dans setGrade
        System.out.println(s2);

        setGrade2(std); //on modifie réellement la valeur de std car on a pas crée un nouvel objet
        String s3 = s_part + std.getGrade(); //on obtient 0 car on a modifié la valeur de std
        System.out.println(s3);

    }
}
