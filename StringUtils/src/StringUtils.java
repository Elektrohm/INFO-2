import java.util.ArrayList;
import java.util.Arrays;

public class StringUtils {

    public static void main(String[] args){
        String[] test = spliteur("Here.I.go",'.');
        System.out.println("first test : " + Arrays.toString(test));
        int test2 = indexOf("hello","h");
        System.out.println("second test : " + test2);
        String test3 = toLowerCase("HelLo WoRlD");
        System.out.println("third test : " + test3);
        boolean test4 = palindrome("102kayak201");
        System.out.println("fourth test : " + test4);
    }
    /*
     * Split the input string 'str' w.r.t the character 'marker' in an array of String
     * for example split("test-test", '-') => {"test", "test"}
     * Must return null if there is no occurrence of 'marker' in 'str'
     */

    public static String [] spliteur(String str, char marker){
        int number = 0;
        int index = 0;
        String word = "";
        for (int i = 0 ; i<str.length()-1 ; i++) {
            if (str.charAt(i) == marker) {
                number++;
            }
        }
        if (number == 0) {
            return null;
        }
        String[] toReturn = new String[number + 1];
        for (int j = 0; j < str.length() ; j++) {
            if (str.charAt(j) == marker) {
                toReturn[index] = word;
                index++;
                word = "";
            } else {
                word += str.charAt(j);
            }
        }
        toReturn[index] = word;
        return toReturn;
        }
    /*
     * Returns the index of the first occurrence of sub in str
     * or -1 if there is no occurrence of sub in str at all.
     * Be careful, we ask you to make CASE SENSITIVE comparison between str and sub.
     */
    public static int indexOf(String str, String sub){
        String[] lst = str.split(sub);
        System.out.println(Arrays.toString(lst));
        if ((lst.length == 1) & (str.length()==lst[0].length())){
            return -1;
        }
        return lst[0].length();
    }

    /*
     * Returns a String with the same characters as 'str' except that
     * all upper case characters have been replaced by their lower case equivalent.
     */
    public static String toLowerCase(String str){
        //utiliser la position des lettres majuscules et leur contreparti dans les chiffres
        StringBuilder new_str = new StringBuilder(str);
        for (int i=0 ; i<str.length() ; i++){
            int place = (int) str.charAt(i);
            if (place>=65 && place<=90){
                new_str.setCharAt(i,(char)(place+32));
            }
        }
        return new_str.toString();
    }


    /*
     * Returns true if the string 'str' is a palindrome (a string that reads the same from
     * left to right AND from right to left).
     */
    public static boolean palindrome(String str){
        int lngth = str.length();
        String reverse = "";
        for (int index=lngth-1 ; index>=0 ; index-- ){
            reverse += str.charAt(index);
        }
        if (reverse.equals(str)){
            return true;
        }
        return false;
    }
}
