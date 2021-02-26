class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //The basic approach is to start searching either from the top right corner or the bottom left corner. This will ensure that for the case of top right corner, if the target is less we always move to the left and if the target is more we always move down.
        // For the case of bottom left corner, if the target is less, we always move up and if the target is more we always move right
        
        
        int row = matrix.length;
        
        int i=0;
        int j=matrix[0].length-1;
        
        while(i<row && j>=0)
        {
                if(matrix[i][j]==target)
                    return true;
                
                else if(matrix[i][j]>target)
                    j--;
                
                else if(matrix[i][j]<target)
                    i++;
        }
        
        return false;
    }
}