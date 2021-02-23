/**
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 */
class Solution {
    public int numberOfSubstrings(String s) {
        //A sliding window technique could be used to get all substrings that contains given characters, iterate until you get all a,b and c in the substring
        
        
        int[] map = new int[3];
        int count =0;
        int end=0;
        int ptr=0;
        int len = s.length();
        int result = 0;
        
        while(end<len)
        {
            while(end<len && count!=3)
            {
                int index = s.charAt(end)-'a';
                if(map[index]==0)
                {
                    count++;
                }
                map[index]++;
                end++;
            }
            
            while(count==3)
            {
                int i = s.charAt(ptr)-'a';
                result+=len-end+1;
                map[i]--;
                if(map[i]==0)
                    count--;
                
                ptr++;
            
            }
        }
        
        return result;
        /*
        Simpler code but a bit complex approach, also faster
        
        int ptr=0;
        int count=0;
        int len = s.length();
        int[] map = {0,0,0};
        
        for(int i=0; i<len; i++)
        {
            int index = s.charAt(i)-'a';
            ++map[index];
            
            while(map[0]>0 && map[1]>0 && map[2]>0)
            {
                int idx = s.charAt(ptr)-'a';
                --map[idx];
                ptr++;
            }
            count+=ptr;
            
        }
        
        return count;
        */
    }
    
}