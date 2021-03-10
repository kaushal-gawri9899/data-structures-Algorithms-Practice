/**
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 * 
 * Input: A = "ab", B = "ba"
 * Output: 1
 * Input: A = "abc", B = "bca"
 * Output: 2
 */
class Solution {
    public int kSimilarity(String A, String B) {
        
        //it says to return the smallest K for which A and B are similar
        //We can treat it like a BFS problem as it will always guarantee us the smallest value
        //Basically create a queue and a visited set to keep track of all pairs of visited string
        
        //We can make this code more cleaner if we replace finding the positions for first mismatched and next mismatched which are to be swapped in a separate method, something like a method that return the neighbours (where neighbours would be a list of strings which are created by swapping positions of chars)
        
        if(A.equals(B))
            return 0;
        
        Queue<String> queue = new LinkedList();
        Set<String> visitedSet = new HashSet<>();
        
        queue.add(A);
        visitedSet.add(A);
        int minSwaps = 0;
        while(!queue.isEmpty())
        {
            minSwaps++;
            int size = queue.size();
            
            while(size-->0)
            {
                String current = queue.poll();
                int i=0;
                //We find the first position in our strings where the characters mismatch
                while(current.charAt(i)==B.charAt(i))
                {
                    i++;
                }
                
                //We store the first unmatched char
                char temp = B.charAt(i);
                //Start iterating again from the next letter
                for(int j=i+1; j<current.length(); j++)
                {
                    //Now we will keep on going until we find another different character in our string which is equal to our temp
                    //This means that we will only swap the ith and jth character when the jth character is wrong 
                    if(current.charAt(j)==B.charAt(j) || current.charAt(j)!=temp)
                    continue;
                    
                    String swapped = swapPos(current, i, j);
                    if(swapped.equals(B))
                        return minSwaps;
                    if(!visitedSet.contains(swapped))
                    {
                        visitedSet.add(swapped);
                        queue.add(swapped);
                    }
                        
                }
                
            }
        }
        
        return minSwaps;
    }
    
    private String swapPos(String S, int i, int j)
    {
        char[] arr = S.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return new String(arr);
    }
}