import java.util.Stack;

public class TowerOfHanoi{

    public static void main(String args[]){
        System.out.println("hello world");
    }

    public static int test(int stackSize){
        return (int) (Math.pow(2, stackSize)-1);
    }


    public static void towerOfHanoi(int n, Stack<Disk> a, Stack<Disk> b, Stack<Disk> c) {
        if (n > 0 ) {
            towerOfHanoi(n-1, a, c, b);
            Disk disk = a.pop();
            b.push(disk);
            towerOfHanoi(n-1, c, b, a);
        }else{return;}
    }

}
