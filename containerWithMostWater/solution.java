/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */

class Solution {
    public int maxArea(int[] height) {
     
        //Iterate in the array of height
        //Keep a counter to count the number of items between the two vertical lines
        //max value is given through height(y coordinate) * counter(distance)
        //Start from the outermost vertical heights, move as the length is reduced
        //Find the length of heights such that now vertical height is greater
        
        int count  = 0;
        int maxArea = 0;
        int maxWidth = height.length - 1;
        
        int endLine = height[height.length-1];
        
        while(count < maxWidth){            
            if(height[count] < height[maxWidth])
                maxArea = Math.max(maxArea, height[count]*(maxWidth-count));
            else
                maxArea = Math.max(maxArea, height[maxWidth]*(maxWidth-count));
            
            if(height[count] < height[maxWidth])
                count++;
            else
                maxWidth--; 
        }
        
        return maxArea;
    }
}