package ca.calculator.terminal;

public class Calculator {
    public static void main(String[] args){
        int Somme = 0;
        for (String i : args){
            int chiffre = Integer.parseInt(i);
            Somme += chiffre;
        }
        System.out.println(Somme);
    }
}
