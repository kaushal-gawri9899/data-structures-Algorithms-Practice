/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        //Brute Force
        //Carry a straight forward search by iterating in the 2d matrix using multiple loops
        //O(n^2) - will be very slow as it will search for unneccesary positions as well
        
        
        //Efficient
        //We can run a binary search for each row 
        //Iterate row wise in the matrix 
        //Make sure to first check the first element of each row, if the element to be searched is greater than the first element and less than the last element of the row, carry forward the search
        //Can be achieved by first binary searching through the rows to get the correct row
        //Then search through the columns using that row
        
        
        // int row = matrix.length;
        int column = matrix[0].length;
        // boolean flag =  false;
        
        int currRow = getSuitableRow(matrix, target);
        
        
        if(currRow!=-1)
        {
            int start = 0;
            int dummy[] = matrix[currRow];
            int end = column -1;
            int mid;
            
            while(start <= end){
                
                //will not let our code overflow the stack
                mid = start+(end-start)/2;
                
                if(dummy[mid]==target)
            //setting up the flag here will reduce time efficiency and thus we want to return as soon as we find the value
                     return true;
                else if(dummy[mid]>target)
                    end = mid -1;
                else
                    start = mid+1;
            }
        }
        
        return false;
        
    }
    
    private int getSuitableRow(int[][] matrix, int target)
    {
        
        int start = 0;
        int end = matrix.length -1;
        int mid ;
        int column = matrix[0].length;
        
        while(start <=end )
        {
            
            mid = start+(end-start)/2;
            
            if(matrix[mid][0]<=target && matrix[mid][column-1]>=target){
                return mid;
            }
            
            else if(matrix[mid][0]>target){
                end = mid -1;
            }
            else
            {
                start = mid +1;
            }
        }
        
        return -1;
    }
    
    
}