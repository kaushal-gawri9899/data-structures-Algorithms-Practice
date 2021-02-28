/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * Input: s = "bcabc"
 * Output: "abc"
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        
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