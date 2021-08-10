import java.util.Arrays;
import java.util.Scanner;

public class IntroductionExercises {
    public static int variable = 0;
    public static int[] squares;
    //fonction qui initialise squares avec le carré des éléments passé en arguments
    /*public static void main(String... args){
        int index = 0;
        squares = new int[args.length];
        while (index<args.length) {
            try {
                int chiffre = Integer.parseInt(args[index]);
                int square = chiffre * chiffre;
                squares[index] = square;
                index++;
            } catch (Exception e) {
                squares[index] = 0;
                index ++;
            }
            System.out.println(Arrays.toString(squares));
        }
    }*/
    public static void main(String args[]){
        //attribution de la valeur value
        Scanner input = new Scanner(System.in);
        System.out.print("Choose The value to replace Variable\n");
        int chiffre = input.nextInt();

        //attribution du premier chiffre à additionner
        Scanner dig1 = new Scanner(System.in);
        System.out.print("Choose your first digit to add\n");
        int a = dig1.nextInt();

        //attribution du deuxième chiffre à additionner
        Scanner dig2 = new Scanner(System.in);
        System.out.print("Choose your second digit to add\n");
        int b = dig2.nextInt();

        //attribution du troisième chiffre à comparer
        Scanner dig3 = new Scanner(System.in);
        System.out.print("Choose your third digit \n");
        int c = dig3.nextInt();

        //attribution du moment de la journée
        Scanner word2 = new Scanner(System.in);
        System.out.print("What time is it ? ");
        String dayTime = word2.nextLine();

        //premier test pour voir si le changement de variable a lieu
        System.out.println("The first value of variable was :" + variable);
        Attribute(chiffre);
        System.out.println("Now its value is : " + variable);

        //deuxième test pour voir si l'addition fonctionne
        int answer = Add(a,b);
        System.out.println("The sum of " + a + " and " + b + " equals " + answer);

        //troisième test pour voir si a et b sont les mêmes
        boolean equal =  equalsIntegers(a,b);
        System.out.println(a + " and " + b + " are equals : " + equal );

        //quatrième test pour voir si la fonction trouve le chiffre milieu
        int milieu = middleValue(a,b,c);
        System.out.println("The middle digit is " + milieu);

        //cinquième test pour voir si le programme renvoie le bon maximum
        int maxValue = max(a,b);
        System.out.println("The maximum value is " + maxValue);

        //sixième test pour voir si le programme renvoie le bon bonjour
        String greets = greetings(dayTime);
        System.out.println(greets);

        //septième test pour voir si le programme renvoie le bon array
        int[] test7 =  {0,1,2,3,4};
        int[] test7bis = {-5,-2,-1,-4,-10,-1};
        int[] result7 = lastFirstMiddle(test7);
        int[] result7bis = lastFirstMiddle(test7bis);
        System.out.println(Arrays.toString(result7));
        System.out.println(Arrays.toString(result7bis));

        //huitième test pour voir si la somme des éléments de l'array fonctionne
        int test8 = sum(test7);
        System.out.println(test8);

        //neuvième test pour voir si on récupère bien le maximum
        int test9 = maxArray(test7);
        int test10 = maxArray(test7bis);
        System.out.println(test9);
        System.out.println(test10);

    }

    //fonction qui change la valeur de variable en value
    private static void Attribute(int value){
        variable = value;
    }

    //fonction qui retourne l'addition de a et b
    private static int Add(int a, int b) {
        return a+b;
    }

    //fonction qui vérifie si deux nombres sont les mêmes
    private static boolean equalsIntegers(int a, int b){
        if (a == b) {
            return true;
        }
        return false;
    }

    //fonction qui renvoie le nombre milieu entre a,b,c sauf si au moins deux sont égaux alors renvoie -1
    private static int middleValue(int a, int b, int c) {
        if (a==b || a==c || b==c){
            return -1;
        }
        if ((a>b && b>c) || (c>b && b>a)){
            return b;
        }
        if ((b>a && a>c) || (c>a && a>b)){
            return a;
        }
        return c;
    }

    //fonction qui renvoie le maximum entre a et b
    private static int max(int a, int b) {
        return (a>b) ? a:b;
    }

    //fonction qui renvoie bonjour en fonction du moment de la journée
    private static String greetings(String str) {
        switch (str){
            case "Morning" :
                return "Good morning, sir!";

            case "Evening" :
                return "Good evening, sir!";
        }
        return "Hello, sir!";
    }

    //fonction qui renvoie le dernier, le premier et l'élément milieu d'un array
    private static int[] lastFirstMiddle(int[] a) {
        int l = a.length;
        int[] NewArray = {a[l-1], a[0], a[l/2]};
        return NewArray;
    }

    //fonction qui renvoie la somme de tous les chiffres présent dans l'array
    private static int sum(int[] array){
        int Somme = 0;
        for (int i : array){
            Somme += i;
        }
        return Somme;
    }

    //fonction qui renvoie l'élément le plus grand d'un array
    private static int maxArray(int[] array){
        int maxValue = array[0];
        int i = 1;
        while (i<array.length){
            if(array[i]>maxValue){
                maxValue = array[i];
            }
            i++;
        }
        return maxValue;
    }

}
