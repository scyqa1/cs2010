import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] a= new double[0];
    	assertArrayEquals(a,SortComparison.insertionSort(a),0);
    	assertArrayEquals(a,SortComparison.selectionSort(a),0);
    	assertArrayEquals(a,SortComparison.quickSort(a),0);
    	assertArrayEquals(a,SortComparison.mergeSortIterative(a),0);
    	assertArrayEquals(a,SortComparison.mergeSortRecursive(a),0);
    }
    

    @Test
    public void testGeneral() {
        double[] a = { 8, 2, 3, 11, 5, 6, 12, 4, 9, 7, 10, 1 };
        double[] aSorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        assertArrayEquals(aSorted, SortComparison.insertionSort(a), 0);
        assertArrayEquals(aSorted, SortComparison.selectionSort(a), 0);
        assertArrayEquals(aSorted, SortComparison.quickSort(a), 0);
        assertArrayEquals(aSorted, SortComparison.mergeSortIterative(a), 0);
        assertArrayEquals(aSorted, SortComparison.mergeSortRecursive(a), 0);
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
