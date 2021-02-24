class Solution {
    public boolean isAnagram(String s, String t) {
        
        //Basically if all the letters of both the words are same, with same count, words are anagrams
        
        if(s.length()!=t.length())
            return false;
        
        int[] map = new int[26];
        int len = s.length();
        
        for(int i=0; i<len; i++)
        {
            //Increase the counter for char at i for s
            //Decrease the counter for char at i for t
            //This is because at the end of iteration, +1 -1 = 0, thus each char in array should be zero
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        
        for(int j : map)
        {
            if(j!=0)
                return false;
        }
        return true;
        
        
//         HashSet<Character> set = new HashSet<Character>();
//         boolean toReturn = false;
        
//         if(s.equals("") && t.equals(""))
//             return true;
        
//         if(s.length()!=t.length())
//             return false;
        
        
        
//         for(int i=0; i<s.length(); i++)
//         {    
//             char ch = s.charAt(i);
//             set.add(ch);
//         }
        
//         for(int i=0; i<t.length(); i++)
//         {    
//             char r = s.charAt(i);
//             if(set.contains(r))
//                 toReturn=true;
//         }
        
//         return toReturn;
    }
}