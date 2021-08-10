import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MaxFinder {
    private final int nThreads,length,width,depth;
    private final int[][][] data;
    private final CyclicBarrier barrier;
    private int[] sums;
    private int max;

    /*
     * Worker constructor takes only one parameter int r, which is his associated row number
     * A worker is responsible of the calculation of the sum of each 2D-Array
     * with row == r + nThread * round; with round >= 0
     *
     * Run should compute the sum of a 2D-array and store the result in sums[] then
     * wait for the cyclic barrier to get the result
     * And restart computing nThreads further
     */
    class Worker implements Runnable {

        final int row;
        Worker(int r){
            this.row = r;
        }

        @Override
        public void run() {
            int i = row;
            while (i<data.length) {
                int sum = 0;
                for(int k = 0 ; k < data[i].length ; k++){
                    for(int j = 0 ; j < data[i][k].length ; j++){
                        sum += data[i][k][j];
                    }
                }
                sums[row] = sum;
                try {
                    barrier.await();
                } catch (Exception e) {
                    return;
                }
                i+= nThreads;
            }
        }

    }


    /*
     *
     * Initialize all the instance variable and start the right amount of Threads
     *
     */
    private MaxFinder(int[][][] matrix, int nThreads) throws InterruptedException{
        //initialisation des variables
        this.nThreads = nThreads;
        this.length = matrix.length;
        this.width = matrix[0].length;
        this.depth = matrix[0][0].length;
        this.data = matrix;
        this.sums = new int[nThreads];
        Runnable barrierAction = () -> {
            int currentMax = Integer.MIN_VALUE;
            for(int i = 0 ; i < nThreads ; i++)
                currentMax = Math.max(currentMax, sums[i]);
            this.max = Math.max(max,currentMax);
        };
        this.barrier = new CyclicBarrier(nThreads, barrierAction);

        //création des threads
        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++){
            threads[i] = new Thread(new Worker(i));
            threads[i].start();
        }

        // wait until done
        for (Thread thread : threads) {
            thread.join();
        }

    }
    /*
    * subSize is the length of the subarray
    * rowSize is the rowlength for all the array
    *
    */
    public static int getMaxSum(int[][][] matrix, int nThreads){
        try{
            MaxFinder mf = new MaxFinder(matrix, nThreads);
            return mf.max;
        }catch(InterruptedException e){
            return -1;
        }

    }

    public static void main(String args[]) throws InterruptedException {
        int[][] l1 = new int[][]{{1,2,3},{4,5,6}};  //21
        int[][] l2 = new int[][]{{2,2,-1},{10,-6,2}}; //9
        int[][] l3 = new int[][]{{-1,-2,-3},{-4,-5,-6}}; //-21
        int[][] l4 = new int[][]{{-10,27,13},{1,-5,0}}; //26
        int[][] l5 = new int[][]{{2,2,2},{2,2,2}};  //12
        int[][] l6 = new int[][]{{-20,7,10},{2,6,3}}; //7
        int[][] l7 = new int[][]{{1,2,3},{4,5,14}}; //29


        int[][][] matrix = {l1,l2,l3,l4,l5,l6,l7};
        int max = getMaxSum(matrix,2);
        System.out.println("Max should be 29 : " + max);
    }
}
