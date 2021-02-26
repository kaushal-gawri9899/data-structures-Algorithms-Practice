/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * Input: "())"
 * Output: 1
 */
class Solution {
    public int minAddToMakeValid(String S) {
        
       int openBracket = 0;
      int closeBracket = 0;
        
        for(int i=0; i<S.length(); i++)
        {
            char ch = S.charAt(i);
            if(ch=='(')
                openBracket++;
            else if(openBracket>0)
                openBracket--;
            else
                closeBracket++;
        }
        
        return openBracket+closeBracket;
        
        //Another way is to only add the character that is either open bracket or close bracket in another data structure and compare the length with the other count
    }
}