import java.util.BitSet;

class Test {
    public static void main(String args[]) {
        int[] tab = new int[]{0,145,857};
        System.out.println(find_tab(tab,145,3));
        System.out.println(find_tab(tab,33,3));
    }

    static int factorial(int n){
        int fact = 1;
        for (int i = 1; i<=n; i++){
            fact = fact*i;
        }
        return fact;
    }

    static int find_tab(int[] tab, int elem, int len){
        for (int i = 0; i<len; i++){
            if (tab[i]==elem){
                return i;
            }
        }
        return -1;
    }
}

