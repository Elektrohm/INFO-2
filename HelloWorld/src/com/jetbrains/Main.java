package com.jetbrains;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter a word \n");
        String word = input.nextLine();

        Scanner digit = new Scanner(System.in);
        System.out.print("Now enter a digit \n");
        int FirstDigit = digit.nextInt();

        Scanner second = new Scanner(System.in);
        System.out.print("A final digit \n");
        int SecondDigit = second.nextInt();

        boolean Test = isEven(FirstDigit);
        boolean Test2 = isEven(SecondDigit);
        int Test3 = Addition(2, 7);

        System.out.println("Is your first digit even : " + Test);
        System.out.println("Is your second digit even : " + Test2);
        System.out.println(Test3);
        System.out.println("You entered the word : " + word);
    }
    private static boolean isEven(int num) {

        if (num % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private static int Addition(int a, int b) {
        return a+b;
    }


}
