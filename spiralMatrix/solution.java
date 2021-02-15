/**
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */


 class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        
        //This is a problem where we need to print the matrix in spiral order
        //Start from (0,0) till last column, move down to last row and then move to the first column and then move up again
        
        List<Integer> toReturn = new ArrayList<>();
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = matrix.length -1;
        int columnEnd = matrix[0].length -1;
       
        while(rowStart <= rowEnd && columnStart <= columnEnd){
            
            //Add the first row all elements
            for(int i = columnStart; i<=columnEnd; i++)
                toReturn.add(matrix[rowStart][i]);
            
            //Add the Last Column all elements
            for(int j = rowStart+1; j<=rowEnd; j++)
                toReturn.add(matrix[j][columnEnd]);
            
            // Add a if check to not let them add a single value twice when size 1x1
            //Now we need to move left such that we end at row end and column 0
            if(rowStart<rowEnd && columnStart < columnEnd)
            {
            for(int i = columnEnd-1; i>columnStart; i--)
                toReturn.add(matrix[rowEnd][i]);
            
            //Now we again move upward
            for(int j=rowEnd; j>rowStart; j--)
                toReturn.add(matrix[j][columnStart]);
            }
            
            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
            
            
        }
        
        return toReturn;
    }
}