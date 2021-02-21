/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
class Solution {

    /** O(n) time and O(n) space */
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> polishNotation = new Stack<Integer>();
        
        
        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                 polishNotation.push(polishNotation.pop() + polishNotation.pop());
            }
            
            else if(tokens[i].equals("-"))
            {
                 polishNotation.push(-polishNotation.pop() + polishNotation.pop());
            }
            
            else if(tokens[i].equals("/"))
            {
                    int div1 = polishNotation.pop();
                    int div2 = polishNotation.pop();
                    polishNotation.push(div2/div1);
            }
            
            else if(tokens[i].equals("*"))
            {
                    polishNotation.push(polishNotation.pop()*polishNotation.pop());
            }
            else
            {
                     polishNotation.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return polishNotation.pop();
    }
}