public class Sorter {
    /**
    * Sorts a list in increasing order
    *
    * We expect this function to behave in O(n^2), where n is the size of the list. 
    * Precisely, we expect that you make at MOST n^2 calls to list.pop() and at 
    * MOST n^2 calls to list.swap(). 
    * 
    * You will obtain the full score for a test case if
    *
    * - The list is sorted (2/4 points per test case)
    * - The list is sorted AND you make less than n^2 calls to swap (1/4 points)
    * - The list is sorted AND you make less than n^2 calls to pop (1/4 points)
    *
    * @param list: a list of integers to be sorted.
    */
    public static void sort(LinkedList list) {
        for(int iter = 0; iter < list.getSize() - 1; iter++) {
            for(int j = 0; j< list.getSize(); j++){
                if (list.getFirst()>list.getSecond() && j!= list.getSize()-1){
                    list.swap();
                }
                list.pop();
            }
        }
    }

    public static void sorter(LinkedList list){
        for(int iter = 0; iter < list.getSize() - 1; iter++) {
            for(int j = 0; j< list.getSize(); j++){
                if (list.getFirst()<list.getSecond()){
                    list.pop();
                } else {
                    list.swap();
                    list.pop();
                }
                System.out.println(list.toString());
            }
            list.pop();
        }
        list.pop();
    }

    public static void main(String args[]){
        LinkedList list = new LinkedList(new int[]{4,1,3,5,8,9,2,10});
        sorter(list);
        System.out.println(list.toString());
    }


}
