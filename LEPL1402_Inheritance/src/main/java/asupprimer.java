public class asupprimer {
    public static void main(String arg[]) {
        int x = 10;
        int a = 20;
        System.out.println("x = " + x);
        {
            // int x = 5; // Won't work
            int y = x * 2;
            System.out.println("y in inner block 1 = " + y);
            x = 50;
            System.out.println("x in inner block 1 = " + x);
        }
    }
}
