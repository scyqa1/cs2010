// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
	 
	private static void swap(double[] a, int i, int j) {
	    double tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
    }
	 
    static double [] insertionSort (double a[]){

        double temp;
        for(int i=1; i<a.length; i++) {
        	for(int j=1; j>0; j--) {
        		swap(a,j,j-1);
        	}
        }
        return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

         int n=a.length;
         for(int i=0; i<n-1; i++) {
        	 int min_idx=i;
        	 for(int j=i+1; j<n; j++) {
        		 if(a[j]<a[min_idx])
        			 min_idx=j;
        	 }
        	 swap(a,i,min_idx);
         }
         return a;

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    
    public static void quickSort(double[] a, int low, int high) {

        if (low >= high) {
            return;
        }

        int i = low, j = high;
        double base = a[low];
        while (i < j) {

            while (a[j] >= base && i < j) {
                j--;
            }

            while (a[i] <= base && i < j) {
                i++;
            }
            swap(a,i,j); 
        }
        swap(a,low,j); 
        
        quickSort(a,low,j-1);  
        quickSort(a,j+1,high);

    }


    static double [] quickSort (double a[]){
    	
    	quickSort(a,0,a.length-1);
    	return a;

    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	

    	//todo: implement the sort
	
   }//end mergeSortRecursive
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class
