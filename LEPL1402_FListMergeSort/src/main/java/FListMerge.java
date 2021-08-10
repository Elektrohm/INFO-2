import java.util.*;

public class FListMerge {

    private static int[] a = new int[]{6, 0, 1, 7, 2, 5};
    private static FList<Integer> tempArray;

    private static int[] asArray(FList list){
        int length = list.length();
        int[] toArray = new int[length];
        int index =0;
        while (index<length-1){
            toArray[index] = (int) list.head();
            list = list.tail();
            index++;
        }
        toArray[index] = (int) list.head();

        return toArray;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public static FList mergeSort(FList fList) {
        if (fList.length()==1){return fList;}

        int half = fList.length()/2;

        FList<Integer> firstHalf = FList.nil();
        FList<Integer> current = fList;
        for (int i = 0; i<half; i++){
            firstHalf = firstHalf.cons(current.head());
            current = current.tail();
        }

        FList<Integer> firstHalfCurrent = mergeSort(reverse(firstHalf));
        FList<Integer> secondHalfCurrent = mergeSort(current);
        FList<Integer> sorted = FList.nil();

        while (!firstHalfCurrent.isEmpty() || !secondHalfCurrent.isEmpty()){
            if (secondHalfCurrent.isEmpty()|| (!firstHalfCurrent.isEmpty() && firstHalfCurrent.head()<secondHalfCurrent.head())){
                sorted = sorted.cons(firstHalfCurrent.head());
                firstHalfCurrent = firstHalfCurrent.tail();
            }else{
                sorted = sorted.cons(secondHalfCurrent.head());
                secondHalfCurrent = secondHalfCurrent.tail();
            }
        }
        return reverse(sorted);
    }

    public static FList<Integer> reverse(FList<Integer> flt){
        FList<Integer> reversed = FList.nil();
        for (int i:flt){
            reversed = reversed.cons(i);
        }
        return reversed;
    }

}