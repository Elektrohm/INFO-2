import java.util.Arrays;

public class Launcher {

    /*
     * Instantiate and start each thread from "t" with its OWN Counter object,
     * then wait for all threads to finish and return the set of Counter objects
     * the threads ran on. Each thread must be named according to its index in the
     * "t" array.
     */
    public static Counter[] init(Thread[] t){
        Counter[] lst = new Counter[t.length];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(Integer.toString(i));
            lst[i] = new Counter();
        }
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }

        /* Wait for all threads to terminate. */

        for (int i = 0; i < t.length; i++) {
            try {
                t[i].join();
                lst[i].run();
            }
            catch (InterruptedException e) {
            }
        }
        return lst;
    }

    public static void main(String args[]){
        Thread[] t = new Thread[5];
        Counter[] result = init(t);
        for (Counter counter:result){
            System.out.println(counter.getCount());
        }
    }
}
