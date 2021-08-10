import java.util.function.Function;
import java.util.stream.Stream;

public class SideEffect{
    int sum = 0;
    public void run(){
        Function< Integer,Integer > add = (i) -> { sum ++; return i + sum;};
        System.out.println(add.apply(3)); // sum = 4 instead of 3
        System.out.println(add.apply(3)); // sum = 5 instead of 6
    }

    public static void main(String[] args){
        SideEffect s = new SideEffect();
        s.run();
        Stream<Integer> stream1 = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
// Apply map THEN filter to each element, (1, 2, ... , 9, 10) then (6, 7, 8, 9, 10)
        Stream<Integer> mappedStream = stream1.map((i) -> ++i).filter((i) -> i > 5);
// Error on next line: "java.lang.IllegalStateException: stream has already been operated
// upon or closed"
//long numberOfIntegerGreaterThanFive = stream1.count();
// Count the number of int greater than 5
        System.out.println("Number of number greater than 5 : " + mappedStream.count());
    }
}