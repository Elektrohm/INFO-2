import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {


    public static void main(String args[]){
        int[] test = {6, 0, 1, 7, 2, 5};
        sort(test);
    }

    public static void sort(int[] a) {
        int number = a.length;
        int [] aux  = new int[number];
        mergesort(a, aux, 0, number - 1);
    }

    public static void mergesort(int[] a, int[] aux, int lo, int hi) {
        if (lo < hi) {
            int mid = (hi + lo)/2;
            mergesort(a,aux, lo, mid);
            mergesort(a,aux,mid + 1, hi);
            merge(a, aux,  lo,  mid,  hi);
        }
    }

    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // Copie certains éléments de a dans aux
        for (int i = lo; i <= hi; i++) {aux[i] = a[i];}
        System.out.println("la sous liste vaut : " + Arrays.toString(aux));

        int i = lo;
        int j = mid + 1;
        int k = lo;

        while (i <= mid && j <= hi) {
            if (aux[i] <= aux[j]) {
                a[k] = aux[i];
                k++;
                i++;
            }
            else {a[k] = aux[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            a[k] = aux[i];
            k++;
            i++;
        }

        System.out.println(Arrays.toString(a));


    }



}