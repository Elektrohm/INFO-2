import java.util.BitSet;

public class Sieve{
    public static BitSet bits;
    public static int numberOfPrime(int n){
        if (n < 2) {return 0;}
        if (n == 2) {return 1;}
        bits = new BitSet();
        bits.flip(2);
        for (int j = 1; 2*j+1 <= n ; j++) {bits.flip(2 * j + 1);}
        for (int i = 3; i * i < n; i += 2) {
            for (int j = i; i * j <= n; j++) {
                bits.clear(i * j);
            }
        }
        return bits.cardinality();
    }
    
}