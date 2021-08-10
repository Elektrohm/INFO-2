package com.jetbrains;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        System.out.println(test1(5));

    }


    Function<Integer, Integer> f1 = (a)-> a + 2;
    Function<String, Integer> mf = (s)->s.length();
    Predicate<Integer> p1 = (a)-> (a % 2) == 0;
    Comparator<String> comp = (s1,s2)->s1.compareTo(s2);
    Comparator<String> compLength = (s1,s2)->s1.length()-s2.length();
}
