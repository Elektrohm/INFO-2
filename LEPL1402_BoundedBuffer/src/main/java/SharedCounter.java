public class SharedCounter {
    private int counter = 0;

    public void inc(){
        synchronized (this) {
            counter++;
            notify();
        }
    }

    public void dec() {
        synchronized (this) {
            try {
                while (counter == 0) {
                    wait();
                }
            } catch (Exception e) {}
            counter--;
            notify();
        }
    }

    public int get(){
        synchronized (this) {
            return counter;
        }
    }
}
