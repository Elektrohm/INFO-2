import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularLinkedList<Item> implements Iterable<Item> {

    private int n;          // size of the list
    private Node last;   // trailer of the list



    // helper linked list class
    private class Node {

        private Item item;
        private Node next;

        private Node(Item item){
            this.item = item;
            this.next = null;
        }

    }

    public CircularLinkedList() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Node getLast(){
        return last;
    }

    public Item getItem(Node n){
        return n.item;
    }



    /**
     * Append an item at the end of the list
     * @param item the item to append
     */
    public void enqueue(Item item) {
        Node newLast = new Node(item);
        if (isEmpty()) {
            last = newLast;
            last.next = last;
        } else {
            Node oldLast = getLast();
            Node FirstElement = oldLast.next ;
            newLast.next = FirstElement;
            oldLast.next = newLast;
            last = newLast;
        }
        n++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     */
    public Item remove(int index) {
        //condition imposé par les profs
        if (index < 0 || index > size()-1){throw new IndexOutOfBoundsException();}
        //si on a qu'un élément réinitialise la liste
        if (size()==1){
            Item item = last.item;
            last = null;
            n = 0;
            return item;
        }
        else{
            int runner = -1;
            Node mover = last;
            while (runner+1!= index){
                mover = mover.next;
                runner++;
            }
            Node removed = mover.next;
            mover.next = removed.next;
            removed.next = null;
            //si on retire le dernier élément on le remplace par l'avant dernier
            if (index == size()-1){
                last = mover;
            }
            n--;
            return  removed.item;
        }
    }


    /**
     * Returns an iterator that iterates through the items in FIFO order.
     * @return an iterator that iterates through the items in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Implementation of an iterator that iterates through the items in FIFO order.
     *
     */
    private class ListIterator implements Iterator<Item> {
        private Node curr;
        private final int nInit = n;
        ListIterator() {
            curr = last;
        }

        private boolean failFastCheck() {
            if (size() != nInit)
                throw new ConcurrentModificationException("bag modified while iterating on it");
            return true;
        }
        @Override
        public boolean hasNext() {
            return (failFastCheck() && curr != null);
        }
        @Override
        public Item next() {
            failFastCheck();
            if (curr == null)
                throw new NoSuchElementException();
            curr = curr.next;
            Item e = curr.item;
            if (curr == last)
                curr = null;
            return e;
        }
    }


}