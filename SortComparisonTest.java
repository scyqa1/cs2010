import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author  Qichen An 19324317
 *  @version HT 2020
 */


/*
 * --------------------|Insertion------|Selection------|Quick----------|MergeIterative-|MergeRecursive-|
 * 10 random-----------| 0.095278ms  --| 0.0018176ms --| 0.0023526ms --| 0.0043843ms --| 0.002994ms  --|
 * 100 random----------| 0.0765646ms --| 0.0578513ms --| 0.0544293ms --| 0.0562473ms --| 0.0574236ms --|
 * 1000 random---- ----| 1.923743ms  --| 1.578667ms  --| 1.110403ms  --| 2.5323046ms --| 2.4238732ms --|
 * 1000 duplicate -----| 0.2785633ms --| 0.9589843ms --| 0.4999166ms --| 1.877868ms  --| 0.7804046ms --|
 * 1000 nearly ordered-| 0.1768686ms --| 0.1433986ms --| 1.5765283ms --| 0.479599ms  --| 1.014911ms  --|
 * 1000 reverse order--| 0.2508673ms --| 0.144147ms  --| 0.1852096ms --| 0.5423693ms --| 1.022717ms  --|
 * 1000 sorted---------| 0.1641436ms --| 0.144147ms  --| 0.1839266ms --| 0.5545596ms --| 0.596157ms  --|
 * 
 * 
 * 
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * Insertion Sort. Because it has a influence on insertion sort to compare and then may swap before completing each insertion. It means for sorted array, the step of swap isn't needed to operate. 
 * And according to results of many times of experiences, insertion sort has bigger impact than others.
 * 
 * b. Which algorithm has the biggest difference between the best and worst performance, based on the type of input, for the input of size 1000? Why?
 * According to results of many times of experience, Insertion Sort has the biggest difference. 
 * Similar to question 1, if an array is already sorted, the step of swap will be not necessary. But for other algorithms, swap is necessary and can't be omitted.
 * 
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time based on the input size? Please consider only input files with random order for this answer.
 * According to experience results, merge sort has the best scalability and selection sort has the worst scalability.
 *  
 * d. Did you observe any difference between iterative and recursive implementations of merge sort?
 * There is just some minor differences. Iterative merge is faster than recursive merge for most of experience results.
 * 
 * e. Which algorithm is the fastest for each of the 7 input files?
 * 10 random                  Selection         
 * 100 random                 Quick
 * 1000 random                Quick
 * 1000 duplicate             Selection
 * 1000 nearly ordered        Selection
 * 1000 reverse order         Quick
 * 1000 sorted                Selection
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
        
        
        double[] b = { 1 };
        double[] bSorted = { 1 };
        
        assertArrayEquals(bSorted, SortComparison.insertionSort(b), 0);
        assertArrayEquals(bSorted, SortComparison.selectionSort(b), 0);
        assertArrayEquals(bSorted, SortComparison.quickSort(b), 0);
        assertArrayEquals(bSorted, SortComparison.mergeSortIterative(b), 0);
        assertArrayEquals(bSorted, SortComparison.mergeSortRecursive(b), 0);
        
        
        double[] c = { 1, 2, 3, 4, 5 };
        double[] cSorted = { 1, 2, 3, 4, 5 };
        
        assertArrayEquals(cSorted, SortComparison.insertionSort(c), 0);
        assertArrayEquals(cSorted, SortComparison.selectionSort(c), 0);
        assertArrayEquals(cSorted, SortComparison.quickSort(c), 0);
        assertArrayEquals(cSorted, SortComparison.mergeSortIterative(c), 0);
        assertArrayEquals(cSorted, SortComparison.mergeSortRecursive(c), 0);
        
        double[] d = { 2, 1 };
        double[] dSorted = { 1, 2 };
        
        assertArrayEquals(dSorted, SortComparison.insertionSort(d), 0);
        assertArrayEquals(dSorted, SortComparison.selectionSort(d), 0);
        assertArrayEquals(dSorted, SortComparison.quickSort(d), 0);
        assertArrayEquals(dSorted, SortComparison.mergeSortIterative(d), 0);
        assertArrayEquals(dSorted, SortComparison.mergeSortRecursive(d), 0);
    }

 
    
    
    
    public static double [] readFile(double a[], String fileName) {
    	try {
            File file = new File(fileName);
            Scanner in = new Scanner(file);
            int num = 0;  
            while (in.hasNext()) {
            	a[num] = in.nextDouble();
            	num++;
            }
            in.close();           
        }
        catch (FileNotFoundException e) {
            System.exit(1);
        }
    	return a;
    }
    
    public static void print(String filename, int n) {
    	
    	double []a=new double[n];
    	double []b=new double[n];
    	
		a=readFile(a, filename);
    	
    	//InsertionSort
		long startTime = System.nanoTime();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.insertionSort(b);
		}
		long finishTime = System.nanoTime();
		System.out.print( (double)(Math.round((finishTime - startTime)*10/3)/10000000.0) + "ms --|");
		
    	//SelectionSort
		startTime = System.nanoTime();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.selectionSort(b);
		}
		finishTime = System.nanoTime();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10000000.0) + "ms --|");
	
    	//QuickSort
		startTime = System.nanoTime();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.quickSort(b);
		}
		finishTime = System.nanoTime();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10000000.0) + "ms --|");
	
    	//MergeSortIterative
		startTime = System.nanoTime();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.mergeSortIterative(b);
		}
		finishTime = System.nanoTime();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10000000.0) + "ms --|");
	
    	//MergeSortRecursive
		startTime = System.nanoTime();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.mergeSortRecursive(b);
		}
		finishTime = System.nanoTime();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10000000.0) + "ms --|\n");
	
    }


    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	System.out.println("\n--------------------|Insertion------|Selection------|Quick----------|MergeIterative-|MergeRecursive-|"); 
    	
    	System.out.print("10 random-----------| "); 
    	print("numbers10.txt",10);
    	
    	System.out.print("100 random----------| "); 
    	print("numbers100.txt",100);
    	
    	System.out.print("1000 random---- ----| "); 
    	print("numbers1000.txt",1000);
    	
    	System.out.print("1000 duplicate -----| "); 
    	print("numbers1000Duplicates.txt",1000);
    	
    	System.out.print("1000 nearly ordered-| "); 
    	print("numbersNearlyOrdered1000.txt",1000);
    	
    	System.out.print("1000 reverse order--| "); 
    	print("numbersReverse1000.txt",1000);
    	
    	System.out.print("1000 sorted---------| "); 
    	print("numbersSorted1000.txt",1000);
    	
    	
    }

}

