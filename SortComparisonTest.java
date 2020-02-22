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
		long startTime = System.currentTimeMillis();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.insertionSort(b);
		}
		long finishTime = System.currentTimeMillis();
		System.out.print( (double)(Math.round((finishTime - startTime)*10/3)/10.0) + "ms  -------|");
		
    	//SelectionSort
		startTime = System.currentTimeMillis();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.selectionSort(b);
		}
		finishTime = System.currentTimeMillis();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10.0) + "ms  -------|");
	
    	//QuickSort
		startTime = System.currentTimeMillis();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.quickSort(b);
		}
		finishTime = System.currentTimeMillis();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10.0) + "ms  -------|");
	
    	//MergeSortIterative
		startTime = System.currentTimeMillis();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.mergeSortIterative(b);
		}
		finishTime = System.currentTimeMillis();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10.0) + "ms  -------|");
	
    	//MergeSortRecursive
		startTime = System.currentTimeMillis();
		for(int i=0;i<3;i++) {
			b=a;
			SortComparison.mergeSortRecursive(b);
		}
		finishTime = System.currentTimeMillis();
		System.out.print(" " + (double)(Math.round((finishTime - startTime)*10/3)/10.0) + "ms  -------|\n");
	
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
    	
    	System.out.print("1000 few unique-----| "); 
    	print("numbers1000Duplicates.txt",1000);
    	
    	System.out.print("1000 nearly ordered-| "); 
    	print("numbersNearlyOrdered1000.txt",1000);
    	
    	System.out.print("1000 reverse order--| "); 
    	print("numbersReverse1000.txt",1000);
    	
    	System.out.print("1000 sorted---------| "); 
    	print("numbersSorted1000.txt",1000);
    	
    	
    }

}
