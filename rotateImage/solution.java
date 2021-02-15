/**
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
 */

class Solution {
    public void rotate(int[][] matrix) {
        
//         int row = matrix.length;
//         int column = matrix[0].length;
        
//        int count = row;
//         for(int i=0; i<(count+1)/2; i++)
//         {
           
//            for(int j=0; j<count/2; j++)
//            { 
        
//                    int temp = matrix[count-1-j][i];
//                    matrix[count-1-j][i] = matrix[count-1-i][count-1-j];
//                    matrix[count-1-i][count-1-j] = matrix[j][count-1-i];
//                    matrix[j][count-1-i]= matrix[i][j];
//                    matrix[i][j] = temp;
 
//            }
//         }
        
        //A better approach is to first take transpose of the matrix and than swap columns (to get its reflection)
        
        transpose(matrix);
        swapColumns(matrix);
    }
    
    private void transpose(int[][] matrix)
    {
        int row = matrix.length;
        int column = matrix[0].length;
        
        for(int i=0; i<row; i++)
        {
            for(int j=i; j<column; j++)
            {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
    }
    
    
    private void swapColumns(int[][] matrix)
    {
        int row = matrix.length;
        int column = matrix[0].length;
        
        int count = column-1;
        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<column/2 ; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][count-j];
                matrix[i][count-j] = temp;
            }
        }
    }
}
