/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        //We can use stack in this solution as well. 
        
        Stack<Integer> stack = new Stack<>();
        
       // int i=0;
        // int len = asteroids.length;
        
        
        for(int i : asteroids)
        {
            if(i>0)
                stack.push(i);
            else{
                //If the value in stack is positive and the current value is greater than the peek of stack (that is say the peek of stack is 10 and current value is -12, in this case 10 should be removed from our stack and thus we do Math.abs(i) which will make -12 as 12 and thus make the condition true so that 10 can be removed)
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()< Math.abs(i))
                {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0)
                    stack.push(i);
                //Both values are equal and in opposite direction
                //Collision will happen
                else if(i + stack.peek()==0)
                {
                    stack.pop();
                }
            }
        }
        
        int[] toReturn = new int[stack.size()];
        
        for(int i=stack.size()-1; i>=0; i--)
        {
            toReturn[i] = stack.pop();
        }
        
        return toReturn;
        
        
    }
}