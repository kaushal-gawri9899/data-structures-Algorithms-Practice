/**
 * Given a string s and an integer k.
 * Return the maximum number of vowel letters in any substring of s with length k. 
 * Input: s = "abciiidef", k = 3
 * Output: 3
 */

class Solution {
    public int maxVowels(String s, int k) {
        
//         //Basic approach is to use sliding window technique with and without extra space
     
//         //Without extra space
        
        int count = 0;
        int maxVowels = 0;
        
        //Counting the vowels in first window of length k
        for(int i=0; i<k; i++)
        {
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                count++;
        }
        maxVowels = count;
        
        //Consider one window of length k at a time after the first window
        for(int j=k; j<s.length(); j++)
        {
            //This is the character to be added to our window
            char ch = s.charAt(j);
            //It specifies the char that is supposed to be removed from our window
            char old = s.charAt(j-k);
            
            //remove the count for the first letter of earlier substring
            if(old=='a'||old=='e'||old=='i'||old=='o'||old=='u')
                count--;
            
            //add the new character for our current substring
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                count++;
           
            
            maxVowels = Math.max(maxVowels,count);
        }
        
        return maxVowels;
        
        //With extra space, create a hashset and add all the vowels
        //Iterate in our string for the substring of size k, have another map to store this substring, increase the counter of this substring in the vowels map and make the rest decrease their counter. 
        //Return the substring with the highest counter 
        
//         HashSet<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        
//         int count = 0;
//         int max = 0;
        
//         for(int i=0; i<k; i++)
//         {
//             if(set.contains(s.charAt(i)))
//                 count++;
//         }
        
//         max = count;
        
//         for(int j=k; j<s.length(); j++)
//         {
//             if(set.contains(s.charAt(j-k)))
//                 count--;
            
//             if(set.contains(s.charAt(j)))
//                 count++;
            
//             max = Math.max(max,count);
//         }
        
//         return max;
    }
}