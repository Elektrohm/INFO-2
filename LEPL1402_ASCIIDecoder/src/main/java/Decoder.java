import java.util.ArrayList;
import java.util.Arrays;

public class Decoder {

    public static void main(String[] args){
        int[] a = {65,66,99};
        String[][] lst = {{"42", "72", "88"},{"98", "99", "111", "47", "55"}};
        System.out.println(Arrays.toString(decode(null,lst)));
    }

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */

    public static String [] decode(int[] forbidden, String[][] sentences){

        //initialisation des variables
        ArrayList<String> intermediate = new ArrayList<String>();
        ArrayList<Integer> forbid = new ArrayList<Integer>();

        if (forbidden == null){forbidden = new int[] {257,258};}
        for (int i : forbidden){
            forbid.add(i);
        }

        for (String[] lst : sentences){
            StringBuilder mot = new StringBuilder();
            for (String caract : lst){
                int ASCII = Integer.parseInt(caract);
                if (!forbid.contains(ASCII)){
                    mot.append(Character.toString((char) ASCII));
                }
            }
            intermediate.add(mot.toString());
        }

        String[] translateList = new String[intermediate.size()];
        translateList = intermediate.toArray(translateList);
        return translateList;
    }

}