/** 
 *  Given a string s of '(' , ')' and lowercase English characters. 

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * 
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int totalCount =0;
        int bracket1 = 0;
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==')')
                bracket1++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                if(totalCount==bracket1)
                    continue;
                totalCount++;
            }
            else if(c==')')
            {
                bracket1--;
                if(totalCount==0)
                    continue;
                totalCount--;
            }
            sb.append(c);
        }
        
        return sb.toString();
        
        
        /**
        Using extra space
        
        
        */
        
//         Stack<Integer> stack = new Stack<Integer>();
        
//         boolean[] checked = new boolean[s.length()];        
//         for(int i=0; i<s.length(); i++)
//         {
//             if(s.charAt(i)=='(')
//                 stack.push(i);
            
//             else if(s.charAt(i)==')')
//             {
//                 if(!stack.isEmpty())
//                 {
//                     checked[i] = true;
//                     //The position of '(' bracket
//                     checked[(int)stack.pop()] = true;
//                 }
//             }
//             else{
//                 checked[i] = true;
//             }
//         }
        
//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<s.length(); i++)
//         {
//             if(checked[i])
//                 sb.append(s.charAt(i));
//         }
        
//         return sb.toString();
    }
}