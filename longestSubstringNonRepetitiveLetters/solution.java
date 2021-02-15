/**
Given a string s, find the length of the longest substring without repeating characters.
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //First thoughts : Probably use a sliding window technique
        //Use map to store the count of each character in the substring
        //Check if the key is already present in map
                //If yes, update the length to be the minimum value of length+1 and the difference between counter and value stored in map
        //Else add the element in map and increase the counter
    
    
        HashMap<Character, Integer> substring = new HashMap<>();
        int len = 0;
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            if(substring.containsKey(ch)){
                len = Math.min(len+1, i-substring.get(ch));
                // System.out.println("Lengthi is " + len);
                substring.put(ch,i);
            }
            else{
                substring.put(ch,i);
                len++;
            }
            if(count < len){
                count = len;
            }
        }
        
        return count;
        
    }
}