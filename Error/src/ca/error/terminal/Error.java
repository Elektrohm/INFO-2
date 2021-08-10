package ca.error.terminal;
import java.util.*;

public class Error {
    public static void main(String... args) {
        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 42;
        Integer i4 = 42;
        String s1 = "EPL";
        String s2 = new String("EPL");
        //va print qu'ils sont pas égaux car la reconnaissance se fait jusque 127
        if (i1 == i2) {
            System.out.println("i1 is equal to i2");
        } else {
            System.out.println("i1 is not equal to i2");
        }
        //va print qu'ils sont égaux car ils sont en dessous du seuil de 127
        if (i3 == i4) {
            System.out.println("i3 is equal to i4");
        } else {
            System.out.println("i3 is not equal to i4");
        }
        //va print qu'ils sont pas égaux car ils pointent pas vers la même référence
        if (s1 == s2) {
            System.out.println("s1 is equal to s2");
        } else {
            System.out.println("s1 is not equal to s2");
        }
        /*Produit une erreur car on retire un élément de la liste qu'on est en train de parcourir = conflit
        List<String> fixedList = Arrays.asList("Apple", "Banana", "Carrot", "Grape");
        List<String> listFruit = new ArrayList<>(fixedList);

        for (String fruit : listFruit) {
            if (fruit.contains("e")) {
                listFruit.remove(fruit);
            }
        }

        //produit parfois une erreur en fonction de la valeur de r, si r=false s devient null, true il devient EPL
        Random r = new Random();
        boolean value = r.nextBoolean();
        System.out.println(value);
        String s = (value) ? "EPL" : null;
        if (s.equals("EPL")) {
            System.out.println("SAME");
        }

        //peut produire une erreur en fonction de si la variable s a été initialisé ou non
        String s;
        if (s.equals("EPL")) {
            System.out.println("SAME");

        //produit toujours une erreur car on ne peut pas appeler la méthode .equals avec null
        String ptr = null;
        if (ptr.equals("EPL")) {
            System.out.println("SAME");
        }
        //String s = "blabla";

        //va produire une erreur NoSuchElement car le dictionnaire ne contient rien
        public static void main(String args[]) {
            Hashtable sampleMap = new Hashtable();
            Enumeration enumeration = sampleMap.elements();
            enumeration.nextElement();
        }*/

        }
    }

