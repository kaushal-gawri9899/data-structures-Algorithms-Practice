/**
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */

class Solution {
    
    int totalCount = 0;
    public int numberOfArithmeticSlices(int[] A) {
        
        //Using recursion, we can check for all pairs
        getNumberOfSlices(A,A.length-1);
        return totalCount;
        
    }
    
    private int getNumberOfSlices(int[] A, int index)
    {
        if(index<2)
            return 0;
        
        int sum =0;
        //Condition to check if difference between current and last elemenet (d) is equal to difference between last element and element before that (like how its done in AP)
        if(A[index]-A[index-1]==A[index-1]-A[index-2])
        {
            sum = 1+getNumberOfSlices(A,index-1);
            this.totalCount+=sum;
        }
        else{
            getNumberOfSlices(A, index-1);
        }
        
        return sum;
    }
}