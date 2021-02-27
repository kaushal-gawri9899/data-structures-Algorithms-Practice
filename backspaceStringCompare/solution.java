/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
            return backspaceCompareHelper(S).equals(backspaceCompareHelper(T));
    }
    
    private String backspaceCompareHelper(String S)
    {
        Stack<Character> stack = new Stack<>();
        
        int len = S.length();
        
        for(int i=0; i<len; i++)
        {
            char ch = S.charAt(i);
            if(ch!='#')
                stack.push(ch);
            else if(!stack.isEmpty())
                stack.pop(); 
        }
        
        return String.valueOf(stack);
    }
    
}