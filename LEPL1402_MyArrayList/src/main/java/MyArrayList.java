import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object [] list;
    private int size;

    public static void main(String args[]){
        Object[] lst = new Object[4];
        System.out.println(Arrays.toString(lst));
    }

    public MyArrayList(int initSize){
        if (initSize<0){throw new IndexOutOfBoundsException();}
        list = new Object[initSize];
        size = 0;
    }


    /*
    * Checks if 'list' needs to be resized then add the element at the end 
    * of the list.
    */
    public void enqueue(Item item){
        if(list.length == size){
            Object[] temp = new Object[size*2];
            for(int i = 0; i<size;i++){
                temp[i]=list[i];
            }
            temp[size]=item;
            list = temp;
        }else{
            list[size]=item;
        }
        size++;
    }


    /*
    * Removes the element at the specified position in this list.
    * Returns the element that was removed from the list. You dont need to 
    * resize when removing an element.
    */
    public Item remove(int index){
        if (index <0 || index > size()-1){throw new IndexOutOfBoundsException();}
        Item removed = (Item) list[index];
        list[index]=list[index+1];
        for (int i = 1 ;  index + i + 1<size() ; i++){
            list[index+i] = list[index+i+1];
        }
        list[size-1] = null;
        size--;
        return removed;
    }


    public int size(){
        return this.size;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        private Item curr;
        private int index;
        private final int nInit = size;

        MyArrayListIterator() {
            curr = (Item) list[0];
            index = 0;
        }

        private boolean failFastCheck() {
            if (size() != nInit)
                throw new ConcurrentModificationException("bag modified while iterating on it");
            return true;
        }

        @Override
        public boolean hasNext() {
            return (failFastCheck() && index < size);
        }
        @Override
        public Item next() {
            failFastCheck();
            curr = (Item) list[index++];
            Item e = curr;
            return e;
        }
    }

}