import java.util.ArrayList;
import java.util.Arrays;

public class MaxSubArray {

    public static void main(String args[]) {
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(maxSubArray(test)));
    }

    public static int[] maxSubArray(int[] a) {
        int[] sub_opti = new int[1];
        int negative_digits_count = 0;

        for (int i : a) {
            if (i <= 0) {negative_digits_count++;}
        }
        if (negative_digits_count == a.length) {return get_biggest(a);}
        int best_sum = 0;
        int best_start = 0;
        int best_end = 0;
        int current_sum = 0;
        int current_start = 0;
        for (int i = 0; i < a.length; i++) {
            if (current_sum <= 0) {
                current_start = i;
                current_sum = a[i];
            } else {
                current_sum += a[i];
            }
            if (current_sum > best_sum) {
                best_sum = current_sum;
                best_start = current_start;
                best_end = i;
            }
        }
        int[] array = new int[]{best_sum, best_start, best_end};
        return array;
    }

    public static int[] get_biggest(int[] a) {
        int biggest = a[0];
        int index = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > biggest) {
                biggest = a[i];
                index = i;
            }
        }
        int[] array = {biggest, index, index};
        return array;
    }

}