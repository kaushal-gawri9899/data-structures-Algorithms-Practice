/**
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * Follow up:
 *  A straight forward solution using O(mn) space is probably a bad idea.
 *  A simple improvement uses O(m + n) space, but still not the best solution.
 *  Could you devise a constant space solution.
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]  
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        
        //Approach : use binary search to search for rows with zero in it
        //Mark the first column of the row and first column for which to make a zero, use this instead of extra space
        //Though, we need to take care of the case where due to one value, the first row and column are marked zero but we either only need to change all zeros in first row or first column, for example 
//  1 1
//  0 1
        // We will need to mark 0,0 with 0 but when checking for zero that will lead us to change the values for both first row, first column, second row which should have been first column and second row
        
        //fastest approach with constant space
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean isFirstColumn = false;
        
        for(int i=0; i<row; i++)
        {
            if(matrix[i][0]==0)
                isFirstColumn = true;
                
            //start with j = 1 
            for(int j=1; j<col; j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //Mark zeros in all relevant rows and columns
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<col; j++)
            {
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }
        
        //Check if first element is zero, if so, we need to make whole row zeros
        if(matrix[0][0]==0)
        {
            for(int j=0; j<col; j++)
                matrix[0][j]=0;
        }
        
        //Check if we need to change first column to zero
        if(isFirstColumn)
        {
            for(int i=0; i<row; i++)
                matrix[i][0] = 0;
        }
        
        
    }
}