import java.util.Stack;

public class MyQueue<E> {

    Stack<E> s1;
    Stack<E> s2;

    private E front;

    /*
     * Constructor
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.front = null;
    }

    // STACK EST UNE LIFO ET ON VEUT UNE FIFO

    /**
     * Push element x to the end of the queue (remember, a queue is FIFO)
     */
    public void enqueue(E elem) {
        if (empty()){this.front = elem;}
        s1.push(elem);
    }

    /**
     * Removes the front element of this queue
     */
    public E dequeue() {
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        E Front = s2.pop();
        while (!s2.empty()){
            enqueue(s2.pop());
        }
      return Front;
    }

    /**
     * Get the first element of this list but does not remove it
     */
    public E peek() {
      return this.front;
    }

    /**
     * Tells if the queue is empty or not.
     */
    public boolean empty() {
      return s1.empty();
    }

}
