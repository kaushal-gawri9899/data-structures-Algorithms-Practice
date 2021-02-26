/**
 *  Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0]. 
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        //This problem is similar to next greater element, though we need to store the difference in the index in our array instead of the value itself
        
        Stack<Integer> stack = new Stack<Integer>();
        int len = T.length;
        int[] result = new int[len];
        
        Arrays.fill(result,0);
        
        for(int i=0; i<len; i++)
        {
            while(!stack.isEmpty() && T[stack.peek()]<T[i])
            {
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }
        
      
        return result;
    }
}