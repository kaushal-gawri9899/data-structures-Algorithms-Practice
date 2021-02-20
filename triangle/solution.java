/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        //int sum=0;
        int[] sum = new int[triangle.size()+1];
        for(int i=triangle.size()-1; i>=0; i--)
        {
            for(int j=0; j<triangle.get(i).size(); j++)
            {
//This makes sure we update the sum such that sum is now the sum of current element in the row + the minimum value of the sum of previous iterations at value j and j+1(as in question)
                sum[j] = triangle.get(i).get(j) + Math.min(sum[j],sum[j+1]);
                
            }
        }
        return sum[0];
    }
    
}