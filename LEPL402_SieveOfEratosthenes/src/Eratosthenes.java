import java.util.BitSet;

public class Eratosthenes {
    public static BitSet bits; //You should work on this BitSet

    public static int numberOfPrime(int n){
        //Trival cases
        if (n<2) return 0;
        if (n<4) return 2;

        //array with each number set to bit 0 = false
        bits = new BitSet(n);
        //setting each odd number to 1 (even number are trival)
        for (int i = 3; i<n+1; i+=2){
            bits.set(i);
        }

        for (int i = 3; i*i<n; i+=2){
            if (bits.get(i)){
                for (int j = i; i*j<=n ; j+=2){
                    bits.clear(i*j);
                }
            }
        }
        return bits.cardinality()+1;
    }

    public static void main(){
        System.out.println("Everything good");
    }
}
