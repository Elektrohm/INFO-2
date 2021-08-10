import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    

    public static void main(String args[]){
        int[] test = {6, 0, 1, 7, 2, 5};
        sort(test);
        System.out.println(Arrays.toString(test));
    }

    public static void sort(int[] a) {
        int number = a.length;
        int [] aux  = new int[number];
        mergesort(a, aux, 0, number - 1);
    }

    public static void mergesort(int[] a, int[] aux, int lo, int hi) {
        if (lo<hi){
            int mid = (hi+lo)/2;
            mergesort(a,aux,lo,mid);
            mergesort(a,aux,mid+1,hi);
            merge(a,aux,lo,mid,hi);
        }

    }

    public static void merge(int[] a, int[] aux, int lo, int mid, int hi){
        for (int i=lo; i<=hi; i++) {aux[i]=a[i];}
        int i = lo;
        int j = mid +1;
        int insertIndex = lo;

        while (i<=mid && j <= hi){
            if (aux[i]<aux[j]){
                a[insertIndex] = aux[i];
                i++;
            }
            else{
                a[insertIndex] = aux[j];
                j++;
            }
            insertIndex++;
        }
        while (i<=mid){
            a[insertIndex] = aux[i];
            i++; insertIndex++;
        }
    }



}