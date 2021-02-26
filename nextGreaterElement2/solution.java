/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number. 
 * 
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; 
 * The number 2 can't find next greater number; 
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<Integer>();
        //HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int[] solution = new int[len];
        Arrays.fill(solution,-1);
        
        for(int i=0; i<2*len; i++)
        {
            
            // while(!stack.isEmpty() && stack.peek()<nums[i%len])
            // {
            //     map.put(stack.pop(),nums[i%len]);
            // }
            
            //We do i%len because it is a circular array so index 1%3 = 1 for length 3 and index 4%3 also 1 for length 3. Basiclly, we again need to visit every element for the element at last position
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i%len])
            {
                solution[stack.pop()] = nums[i%len];  
            }
            //stack.push(nums[i%len]);
            stack.push(i%len);
        }
        
//         for(int i=0; i<len; i++)
//         {
//             nums[i] = map.getOrDefault(nums[i%len],-1);
//         }
        
        return solution;
    }
}