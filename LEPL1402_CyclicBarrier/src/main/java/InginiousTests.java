
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Comparator;



import java.util.Random;

import static org.junit.Assert.*;

public class InginiousTests {

    private static Random rng = new Random();
    private static boolean firstTestFlag=false;

    private static int[][][] generateArray(int size, int nThread){
        int[][][] matrix = new int[100*nThread][size][size];

        for(int i = 0 ; i < 100*nThread ; i++){
            for(int j = 0 ; j < size ; j++){
                for(int k = 0 ; k < size ; k++ ){
                    matrix[i][j][k] = rng.nextInt(100);
                }
            }
        }

        return matrix;
    }

    private static int maxSum(int[][][] matrix){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < matrix.length ; i++){
            int sum = 0;
            for(int j = 0 ; j < matrix[0].length ; j++){
                for(int k = 0 ; k < matrix[0][0].length ; k++){
                    sum+= matrix[i][j][k];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    @Test()
    public void testCreateWorker(){

        int[][][] matrix = generateArray(100,11);

        int max = maxSum(matrix);

        int result = MaxFinder.getMaxSum(matrix, 11);

        if(firstTestFlag){
            System.out.println("True");
        }

    }

    @Test()
    public void testMaxFinder() {

        if(!firstTestFlag){
            System.out.println("True");
        }
        int[][][] matrix = generateArray(100,11);

        int max = maxSum(matrix);

        int result = MaxFinder.getMaxSum(matrix, 10);

        if(max==result){
            System.out.println("True");
        }


    }

    @Test()
    public void testWorker() {

        if(!firstTestFlag){
            System.out.println("False");
        }

        int[][][] matrix = generateArray(100,11);

        int max = maxSum(matrix);

        int result = MaxFinder.getMaxSum(matrix, 10);

        if(max==result)
            System.out.println("True");

    }

    @Test()
    public void testGlobal()  {

        if (!firstTestFlag)
            System.out.println("False");

        int[][][] matrix = generateArray(100, 11);

        int max = maxSum(matrix);

        int result = MaxFinder.getMaxSum(matrix, 10);

        if (max == result) {
            System.out.println("True");
        }
    }
}