/**
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 *
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 */
class Solution {
    
    // Map<Integer, Integer> parent = new HashMap<>();
     int[] parent = new int[26];
     
     public boolean equationsPossible(String[] equations) {
         
         for(int i=0; i<26; i++)
         {
             parent[i] = i;
             
              //If we use a hashmap instead
             //parent.put(i,i);
         }
         
         
         //Take union of all equations if equality is used and map it on parent
         for(String s : equations)
         {
             if(s.charAt(1)=='=')
             {
                 int x = find(s.charAt(0)-'a');
                 int y = find(s.charAt(3)-'a');
 
                 parent[x] = y;
                 
                                 
                 //If we use a hashmap instead
                 //parent.put(x,y);
             }
         }
         
         
         //Find the mapping of chars where inequality is used and using find, see the reference of the chars, if they are equal return false as we can't have the same set of chars in inequality set as that of in equality sets
         for(String s : equations)
         {
             if(s.charAt(1)=='!')
             {
                 int x = find(s.charAt(0)-'a');
                 int y = find(s.charAt(3)-'a');
                 
                 
                 if(x==y)
                     return false;
             }
         }
         
         return true;
     }
     
     private int find(int key)
     {
        
         if(parent[key]==key)
             return key;
         
         
             return find(parent[key]);
         
         /*
         
         If we use a hashmap
         
         if(parent.get(key)==key)
             return key;
             
         return find(parent.get(key));
         */
     }
     
 
 }