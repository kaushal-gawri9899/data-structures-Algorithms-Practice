/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        
        int len = heights.length;
     
        int maxArea = 0;
        int i=0;
        //Max Area on the right side
        while(i<=len)
        {
            //If either the stack is empty or the value at peek is less than heights[i], add it to the stack
            int h=0;
            if(i==len)
                h=0;
            else
                h=heights[i];
                
            if(stack.isEmpty() || heights[stack.peek()]<=h)
            {
                stack.push(i);
                i++;
            }
            //Else if the value is smaller than the stack, we keep on removing the values from stack such that if stack becomes empty we multiply by i which is the right index of current bar (for width) and else if it isn't we multiply by the left index of the bar
            // 
            else{
                int top = stack.pop();
                int rightSide = i-1; 
               // maxArea = Math.max(maxArea, )
                if(stack.isEmpty())
                {
                    //when stack is empty, we consider the element at the next of the peek, that is the right value of peek
                    int leftSide = 0;
                    int width = rightSide - leftSide + 1;
                    maxArea = Math.max(maxArea, heights[top]*i);
                }
                else{
                    //when stack is non empty, we need to consider the element before the top of the stack given by stack.peek()-1
                    int leftSide = stack.peek()+1;
                    int width = rightSide - leftSide + 1;
                    maxArea = Math.max(maxArea, heights[top]*(width));
                }
            }
        }
        return maxArea;
    }
}