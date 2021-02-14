/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
*/ 

class Solution {
    public void reverseString(char[] s) {
        
        int pos = s.length-1;
        int mid = (s.length +1 )/2;
        for(int i=0; i<mid; i++, pos--)
        {
            char temp = s[i];
            s[i] = s[pos];
            s[pos] = temp;
        }
        
        
    }
}