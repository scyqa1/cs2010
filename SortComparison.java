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

        for(int i=1; i<a.length; i++) {
        	for(int j=i; j>0; j--) {
        		if(a[j]<a[j-1])
        		{
        		    swap(a,j,j-1);
        		}
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
        		 if(a[j]<a[min_idx]) {
        			 min_idx=j;        			 
        		 }
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

        double base = a[low];
        int i = low, j = high+1;
        
        while (i<j) {
    	
        	
        	System.out.print("i:"+i); 
        	
            while (a[++i] < base && i!=high) {

            }
            while (a[--j] > base && j!=low) {

            }

            if(i<j)
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
    
    private static void merge(double []a,int left,int mid,int right){
        double []temp=new double[a.length];
        int p1=left,p2=mid+1,k=left;

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                temp[k++]=a[p1++];
            else
                temp[k++]=a[p2++];
        }

        while(p1<=mid) temp[k++]=a[p1++];
        while(p2<=right) temp[k++]=a[p2++];


        for (int i = left; i <=right; i++)
            a[i]=temp[i];
    }

    static double[] mergeSortIterative (double a[]) {
        for(int sz=1; sz<a.length; sz=sz+sz)
        	for(int lo=0; lo<a.length-sz; lo+=sz+sz)
        		merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));
		return a; 
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
 

    private static void mergeSortRecursive(double [] a,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSortRecursive(a, start, mid);
            mergeSortRecursive(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }
    
    static double[] mergeSortRecursive (double a[]) {

    	mergeSortRecursive(a, 0, a.length-1);
        return a;
	
    }//end mergeSortRecursive
    	
    


   

/*
    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }
*/

 }//end class
