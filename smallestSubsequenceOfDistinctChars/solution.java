/**
 * Return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 * 
 * Input: s = "bcabc"
 * Output: "abc"
 */
class Solution {
    public String smallestSubsequence(String s) {
         Stack<Character> stack = new Stack<>();
        
        int len = s.length();
        int[] count = new int[26];
        
        boolean[] marked = new boolean[26];
        
        char[] arr = s.toCharArray();
        
        for(char c : arr)
        {
            count[c-'a']++;
        }

        for(char c : arr)
        {
            count[c-'a']--;
            
            if(marked[c-'a'])
                continue;
            
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a']>0)
            {
                marked[stack.pop()-'a']=false;
            }
            
            stack.push(c);
            marked[c-'a']=true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}