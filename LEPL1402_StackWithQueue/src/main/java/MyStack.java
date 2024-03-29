import java.util.Collections;
import java.util.LinkedList;

public class MyStack<E> {

    private LinkedList<E> queue;

    public static void main(String argss[]){
        MyStack lst = new MyStack();
        lst.push("blabla");
        lst.push("alexandre says ");
        System.out.println(lst.pop());
        System.out.println(lst.peek());
        System.out.println(lst.empty());
        System.out.println(lst.toString());
    }

    //constructeur
    public MyStack() {
        this.queue = new LinkedList<>();
    }


    //push an element at top (remember, a stack is "Last In First Out")

    public void push(E elem) {
        this.queue.add(0,elem);
    }


    //Return the top of the stack AND remove the retrieved element

    public E pop() {
        return this.queue.pop();
    }


    //Return the top element of the stack, without removing it

    public E peek() {
        return this.queue.peek();
    }


    //Tells if the stack is empty or not

    public boolean empty() {
      if (this.queue.size() == 0 ){return true;}
      return false;
    }

    public String toString(){
        return this.queue.toString();
    }


}
