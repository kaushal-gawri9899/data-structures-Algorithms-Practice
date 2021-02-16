/**
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
 */


class Solution {
    public void setZeroes(int[][] matrix) {
        
        //To make use of constraint space, we can keep a track of the whole column or row to be marked zero instead of each value
       // can try updating the values in matrix itself
        
        boolean isPresent = false;
        
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        
        for(int i=0; i< row; i++)
        {
            
            //Check if there's a 0 in the first column itself of any of the rows
              if(matrix[i][0]==0)
                 isPresent = true;
                
            
            //Start from 2nd column as 1st is the special case
            for(int j=1; j<column; j++)
            {
                //Mark first element of rows and columns as zero if it is supposed to be swaped with zeros
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<column; j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        
        //Now check if the first row has a zero and need to be changed to all zeros
        if(matrix[0][0]==0)
        {
            for(int j=0; j<column; j++)
                matrix[0][j] = 0;
        }
        
        //Now check fi the first column has a zero and need to be changed to all zeros
        if(isPresent)
        {
            for(int i=0; i<row; i++)
                matrix[i][0] = 0;
        }
        
        /*We need to keep a track for our first row and first column, as per this logic even if there's a 0 at say position 0,2 we would updated 0,0 with 0 which will further mark the whole first row and third column with zero, instead we just want to mark the 3rd column with zero
        */
        
        
        
        
        //Uses additional space and is slower
        //Constraint is to use constant space
//         int row = 0;
//         int column = 0;
        
//         HashSet<Integer> rows = new HashSet<>();
//         HashSet<Integer> columns = new HashSet<>();
        
//         for(int i=0; i<matrix.length; i++)
//         {
//             for(int j=0; j<matrix[0].length; j++)
//             {
//                 if(matrix[i][j]==0)
//                 {
//                    rows.add(i);
//                     columns.add(j);
//                 }
//             }
//         }
        
//         for(int i=0; i<matrix.length; i++)
//         {
//             for(int j=0; j<matrix[0].length; j++)
//             {
//                 if(rows.contains(i) || columns.contains(j))
//                     matrix[i][j] = 0;
//             }
//         }
        
        
    }
    
    
    //  1       1       1
  //    oo      o1     o2 
    //  1       0       1
  //    1o      11      12
    //  1       1       1
  //    2o      21      22  
    
    //search for position where elem = 0, if i==pos || j==newpos , make zeros 
    
}