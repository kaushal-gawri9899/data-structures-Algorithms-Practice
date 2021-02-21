/**
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 */
class Solution {
    public int numberOfSubstrings(String s) {
        
        //Basic idea is to use sliding window technique
        
        int[] map = new int[3];
        int count =0,end=0,result=0,ptr=0;
        int len = s.length();
        
        
        while(end<len)
        {
            while(end<len && count!=3)
            {
                int index = s.charAt(end)-'a';
                if(map[index]==0)
                    count++;
                    map[index]++;
                end++;
            }
            
            //Make sure that the substring consists of all 'a', 'b', 'c'
            while(count==3)
            {    
                //calulcate the total number of substrings
                result+=len-(end-1);
                int idx = s.charAt(ptr)-'a';
                //decrease the counter for particular element
                map[idx]--;
                //if a character is removed completely, decrease the count
                if(map[idx]==0)
                {
                count--;  
                }
                ptr++;
            }
        }
        return result;
        
        //More faster solution with a bit complicated logic
        //We first increment the values at given position of are array if a,b,c found
        //if value in map is greater than zero, we reduce these values and increase the ptr(defining the number of substrings)
        

//         int[] map = {0,0,0};
        
//         int count = 0;
//         int ptr = 0;
        
        
//         for(int i=0; i<s.length(); i++)
//         {
//                 //This works as a counter as if s.charAt(i)='a', 'a'-'a' = 0, 'b'-'a' = 1 and so on
//                 //Increment the values at particular positions to 
//                 ++map[s.charAt(i)-'a'];
            
//             while(map[0]>0 && map[1]>0 && map[2]>0)
//             {
//                 --map[s.charAt(ptr)-'a'];
//                 ptr++;
//             }
//             count+=ptr;
//         }
//         return count;

                 
    }
}