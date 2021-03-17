/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Input: s = "foo", t = "bar"
 * Output: false (It is false because mapping of o in s should be equal to mapping of a whereas there are two values a and r to be mapped to o which is not possible)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        /*
        We basically need to map characters at index i for string s to that of string t
        For that we create two arrays and at the indices of characters in an arrays
        Then we compare the indices in both the arrays, if they are different for a char at particular position, we return false
        
        If we find any contradiction in the mapping, we return false
        For example : for s = "egg" and t="add"
        
        For the above example, the indices for both e and a(at index 0 in both string) should be same in both of our maps, then only it will be termed as isomorphic
        */
        
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        
        Arrays.fill(map1,-1);
        Arrays.fill(map2,-1);
        
        for(int i=0; i<s.length(); i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;
            
            map1[s.charAt(i)] = i;
            map2[t.charAt(i)] = i;
        }
        
        return true;
    }
}