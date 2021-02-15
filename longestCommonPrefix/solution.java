/**
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string ""

Input: strs = ["flower","flow","flight"]
Output: "fl"
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        //int count = 0;
        if(strs==null || strs.length==0){
            return "";
        }
        for(int j=0; j<strs[0].length() ; j++){
            char c = strs[0].charAt(j);
            for(int i=1; i<strs.length; i++){
                if(j==strs[i].length() || strs[i].charAt(j)!=c){
                    return strs[0].substring(0,j);
                }
                
            }
        }
        return strs[0];
    }
}