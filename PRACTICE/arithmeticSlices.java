/**
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * A slice (P, Q) of the array A is called arithmetic if the sequence:
 * A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 */
class Solution {
    
    int totalSlices=0;
    
    public int numberOfArithmeticSlices(int[] A) {
        //Recursive approach to check for all permutations such including A such that difference between A[i]-A[i-1] is always equal to A[i-1]-A[i-2] (A[i+1]-A[i])
        
        numOfSlicesHelper(A,A.length-1);
        return totalSlices;
    }
    
    private int numOfSlicesHelper(int[] A, int index)
    {
        if(index<2)
            return 0;
        
        int sum = 0;
        
        if(A[index]-A[index-1]==A[index-1]-A[index-2])
        {
            sum = 1+numOfSlicesHelper(A,index-1);
            this.totalSlices+=sum;
        }
        else{
            //if d is not same, we move on to next elements for further subsets
            numOfSlicesHelper(A,index-1);
        }
        
        return sum;
    }
}