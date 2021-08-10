import org.junit.Test;
import static org.junit.Assert.*;

public class TestSuite{

    @Test
    public void testCorrectness(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        assertEquals(templates.Search.binarySearch(arr, 2, 8, 5 ), 4);
        assertEquals(templates.Search.binarySearch(arr, 0, 3, 5 ), -1);
        assertEquals(templates.Search.binarySearch(arr, 1, 8, 9 ), 8);
        assertEquals(templates.Search.binarySearch(arr, 0, 2, 1 ), 0);
        assertEquals(templates.Search.binarySearch(arr, 2, 8, 13 ), -1);

        int[] unsorted = {1,2,3,4,7,0,5,9};
        assertEquals(templates.Search.binarySearch(unsorted,0,4,1), 0);
    }

    @Test
    public void testPreCondition(){
        int[] unsorted = {1,2,3,4,7,0,5,9};
        //check if sorted
        assertNotEquals(templates.Search.binarySearch(unsorted, 2, 8, 5 ), 6);
        assertEquals(templates.Search.binarySearch(unsorted, 0, 5, 1 ), -2);
        assertEquals((templates.Search.binarySearch(unsorted, 5,7,0)),5);

        int[] sorted = {0,1,2,3,4,5,6,7,8,9};
        //check low >= 0
        assertEquals(templates.Search.binarySearch(sorted, -1, 8, 5 ), -2);
        assertNotEquals(templates.Search.binarySearch(sorted, 0,8,5),-2);
        //check hi<=array size
        assertEquals(templates.Search.binarySearch(sorted, 0, 11, 5 ), -2);
        assertNotEquals(templates.Search.binarySearch(sorted, 0,9,3),-2);
        //check low<=hi
        assertEquals(templates.Search.binarySearch(sorted, 5, 4, 4 ), -2);
        assertNotEquals(templates.Search.binarySearch(sorted,0,0,0),-2);
    }

    // Add more tests here.

}
