/**
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 * A substring is a contiguous sequence of characters within a string.
 * 
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] count = new int[26];
        
        Arrays.fill(count,-1);
        
        int total = -1;
        
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i); 
            if(count[ch-'a']==-1)
            {
                //If character showed first time, store the position of its occurence
                count[ch-'a'] = i;
            }
            else
            {
                //If character already present, get the length of substring given by current position - earlier position of letter - 1
                int val = i - count[ch-'a'] - 1;
                total = Math.max(total,val);
            }
        }
        
        return total;
    }
}