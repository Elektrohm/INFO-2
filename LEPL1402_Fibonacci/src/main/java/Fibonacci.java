public class Fibonacci {
    // on veut le nombre se trouvant à l'index "index" dans la suite de fibonnaci
    // donc pour index = 5 : {0,1,1,2,3,5,8,13,21} donnerait 5
    // f(n) = f(n-1)+f(n-2)

    public static void main(String args[]){
        System.out.println("fiboIterative : " + fiboIterative(5));
        System.out.println("fiboRecursive : " +fiboRecursive(5));
        System.out.println("fiboIterative : " +fiboIterative(0));
        System.out.println("fiboRecursive : " +fiboRecursive(0));
        System.out.println("fiboIterative : " +fiboIterative(1));
        System.out.println("fiboRecursive : " +fiboRecursive(1));
        System.out.println("fiboIterative : " +fiboIterative(10));
        System.out.println("fiboRecursive : " +fiboRecursive(10));
        System.out.println("fiboIterative : " +fiboIterative(25));
        System.out.println("fiboRecursive : " +fiboRecursive(25));
    }

    public static int fiboRecursive(int index){
        if (index <= 1){return index;}
        int number_at_index = fiboRecursive(index-1) + fiboRecursive(index-2);
        return number_at_index;
    }

    public static int fiboIterative(int index){
        int[] last_2_fibonumber = {0,1};
        if (index<2){return index;}
        for(int iteration = 2 ; iteration <= index ; iteration++ ){
            int new_number = last_2_fibonumber[0] + last_2_fibonumber[1];
            last_2_fibonumber[0]=last_2_fibonumber[1];
            last_2_fibonumber[1]=new_number;
        }
        return last_2_fibonumber[1];
    }

}
