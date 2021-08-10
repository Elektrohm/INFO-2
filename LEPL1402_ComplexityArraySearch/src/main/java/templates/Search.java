package templates;

public class Search {

    public static void main(String args[]){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(search(array,10));
    }

    public static int search(int[] tab, int elem){
        int first = 0;
        int last = tab.length - 1;
        int mid = (last+first)/2;
        boolean found = false;
        while (first<=last && found!=true) {
            if (elem == tab[mid]) {found = true;}
            else {
                if (elem > tab[mid]) {first = mid + 1;}
                else {last = mid - 1;}
            }
            mid = (last + first) / 2;
        }
        if (found){return mid;}
        return -1;
    }

    //il s'agit de la mission module 4 blackbox testing binary search ce qui suit

    public static boolean isSorted(int[] list,int low,int hi){
        int previous = list[low];
        for (int i = low+1; i<=hi ; i++){
            if (previous > list[i]){return false;}
            previous = list[i];
        }
        return true;
    }

    public static int binarySearch(int[] tab, int low, int hi, int elem){
        if ((low<0) || (hi>tab.length) || (low>hi) || (!isSorted(tab,low,hi))){return -2;}
        int first = low;
        int last = hi;
        int mid = (last+first)/2;
        boolean found = false;
        while (first<=last && found!=true) {
            if (elem == tab[mid]) {found = true;}
            else {
                if (elem > tab[mid]) {first = mid + 1;}
                else {last = mid - 1;}
            }
            mid = (last + first) / 2;
        }
        if (found){return mid;}
        return -1;
    }

}
