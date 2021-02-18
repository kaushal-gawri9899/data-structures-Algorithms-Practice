/**
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4] 
 
 */

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        
       
        //Total number of zeros in a row can be determined by mat[0].length - position of first 0
        //MaxValue for a row is calculated as number of rows*(position of first 0 in a row) + row
        
        int R = mat.length;
        int C = mat[0].length;
        //int index=0;
        
        int[] maxValue = new int[R];
        
        for(int i=0; i<R; i++)
        {
            int index=0;
            for(; index<C; index++)
            {
                if(mat[i][index]==0)
                {
                    break;
                }
                
            }
            maxValue[i] = R*index + i;
        }
        Arrays.sort(maxValue);
        for(int i =0; i<maxValue.length; i++)
        {
            //System.out.println(maxValue[i]);
             maxValue[i]= maxValue[i]%R;
        }
 
        int[] toReturn = new int[k];
        for(int i=0; i<k; i++)
        {
            toReturn[i] = maxValue[i];
        }
        
        return toReturn;
     
    }
}