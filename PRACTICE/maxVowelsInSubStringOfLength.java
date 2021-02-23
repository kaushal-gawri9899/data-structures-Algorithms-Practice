class Solution {
    public int maxVowels(String s, int k) {
        
        //Sliding Window approach
        
        
        //Without using extra space
        int count = 0;
        int maxVowels = 0;
        int len = s.length();
        
        for(int i=0; i<k; i++)
        {
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                count++;
        }
        
        maxVowels = count;
        
        for(int i=k; i<len; i++)
        {
            char ch = s.charAt(i);
            char old = s.charAt(i-k);
            
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                count++;
            
            if(old=='a'||old=='e'||old=='i'||old=='o'||old=='u')
                count--;
            
            maxVowels = Math.max(maxVowels, count);
            
        }
        
        return maxVowels;
        
        //Using extra space
//         HashSet<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        
//         int toReturn = 0;
//         int maxVowels=0;
        
//         for(int i=0; i<k; i++)
//         {
//             if(set.contains(s.charAt(i)))
//                 maxVowels++;
//         }
        
//         toReturn = maxVowels;
        
//         for(int i=k; i<s.length(); i++)
//         {
//             if(set.contains(s.charAt(i-k)))
//                maxVowels--;
//             if(set.contains(s.charAt(i)))
//                maxVowels++;
               
//             toReturn = Math.max(toReturn,maxVowels);
//         }
               
//         return toReturn;
    }
}