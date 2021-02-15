/**
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
 */


 class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = n-1;
        int columnEnd = n-1;
        
        
        //Move right in first row
        //Move down the last column
        //Move left in last row
        //Move back Up

        int val2 = 1;
        int newVal =0;
        while(rowStart <=rowEnd && columnStart<=columnEnd)
        {
            
            //move right side
            for(int j=columnStart; j<=columnEnd; j++)
                matrix[rowStart][j] = val2++;
            
            
            //Move downward
            for(int j = rowStart+1; j<=rowEnd; j++)
                matrix[j][columnEnd] = val2++;
            
            //Now we move to the left side
            for(int i = columnEnd-1; i>=columnStart; i--)
                matrix[rowEnd][i] = val2++;
            
            //Now we again move upward
            for(int j=rowEnd-1; j>rowStart; j--)
                matrix[j][columnStart] = val2++;
          
            
            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
            
            
        }
        
        return matrix;
    }
}