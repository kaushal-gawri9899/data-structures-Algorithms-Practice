/**
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?
 *
 * Input: strs = ["tars","rats","arts","star"]
 * Output: 2 
 */
class Solution {
    public int numSimilarGroups(String[] strs) {
        
        
        /*
        This problem is something similar to another string problem where we start from begin word and travel to endWord and count all the similar words with one position swapped
        
        In this case we have exactly two positions swapped
        
        We can use union find or dfs to achieve this
        */
        
        /*Solution Using Union Find*/
        
        //Check if only 1 letter or empty string
        if(strs.length==0 || strs.length==1)
            return strs.length;
        
        int[] parent = new int[strs.length];
        
        //Initiliaze the references for our parent array
        for(int i=0; i<parent.length; i++)
            parent[i] = i;
        
        int toReturn = strs.length;
        
        for(int i=0; i<strs.length; i++)
        {
            for(int j=i+1; j<strs.length; j++)
            {
                //Check only when they can be similar after two letter swaps
                if(isSimilar(strs[i],strs[j]))
                {
                    int a = find(i,parent);
                    int b = find(j,parent);
                    
                    parent[a] = b;
                    if(a!=b)
                        toReturn--;
                }
            }
        }
          
        return toReturn;
    }
    
    public boolean isSimilar(String a, String b)
    {
        int count=0;
        for(int i=0; i<a.length(); i++)
        {
            if(a.charAt(i)!=b.charAt(i))
                count++;
            
            if(count>2)
                return false;
            
        }
        
        return true;
    }
    
    public int find(int key, int[] parent)
    {
        if(parent[key]==key)
            return key;
        
        return find(parent[key],parent);
    }
}