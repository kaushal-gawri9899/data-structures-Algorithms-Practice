/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       
        int row = 0;
        int column = matrix[0].length-1;
        

        while(column>=0 && row<=matrix.length-1)
        {
            if(target==matrix[row][column])
                return true;
            
            //If the current value is greater than target, target cannot be in next row as values keep on decreasing as we move down, thus it should be in earlier columns
            if(target<matrix[row][column])
                column--;
            //If the current value is less than target, target cannot be in earlier column as values keeps on decreasing so it should be in next rows
            else
                row++;
        }
        
        return false;
    }
    
    
}