/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks. 
 * 
 * Input: [[1,2,2,1],
        [3,1,2],
        [1,3,2],
        [2,4],
        [3,1,2],
        [1,3,1,1]]

 * Output: 2
 */
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        /*Logic is to find sum of adjacent bricks and add such values in our map
          Now, we would choose the value which is present more frequently in our wall
          Say, for this example, 3+1 = 4 is most present, in our 6 rows (except for the last edge), thus we will choose to make a cut after skipping the bricks which sum upto 3+1 = 4 in each row.
          In the end we will return the value such that we return the difference between the number of rows in our wall and leftSum (As, sum of 4 (3+1 or 1+3) is present in our 4 walls, thus we will return 6-4 = 2 which will be the rows to be cut skipping the edge with 3+1 or 1+3 bricks)
        */
         Map<Integer, Integer> countMap = new HashMap<>();
        // int[] countMap = new int[wall.size()];
        
         int totalRows = wall.size();
        
         int maxCut = 0;
        
         for(List<Integer> row : wall)
         {
             int leftSum = 0;
             
             for(int i=0; i<row.size()-1; i++)
             {
                 leftSum+=row.get(i);
                 // countMap[leftSum]++;
                 countMap.put(leftSum, countMap.getOrDefault(leftSum,0)+1);
                 
                 maxCut = Math.max(maxCut, countMap.get(leftSum));
                // maxCut = Math.max(maxCut, countMap[leftSum]);
             }
             
         }
        
        return totalRows-maxCut;
    }
}