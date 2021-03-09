/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:
 *   The first word in the sequence is beginWord.
 *   The last word in the sequence is endWord.
 *   Only one letter is different between each adjacent pair of words in the sequence.
 *   Every word in the sequence is in wordList.
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words. 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //This will be considered as a graph problem
        //The idea is to use a bfs approach where we start from beginword, visit all its neighbour and mark it. Say, we start from begin word hit, we need to travel through a word in which only one letter is changed, which in this case would be hot, hence we can consider hot to be a neighbour of hit and then we traverse to its neighbour using BFS
        
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList();
        int wordCount =1;
        queue.offer(beginWord);
       
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-->0)
            {
                String word = queue.poll();
        
                char[] arr = word.toCharArray();
                
                for(char ch=0; ch<arr.length; ch++)
                {
                    char current = arr[ch];
                    
                    for(char letter='a'; letter<='z'; letter++)
                    {
                        if(arr[ch]!=letter)
                        {
                            arr[ch] = letter;
                        
                        String currentWord = String.valueOf(arr);
                        
                        if(currentWord.equals(endWord))
                            return wordCount+1;
                        
                        if(set.contains(currentWord))
                        {
                            queue.add(currentWord);
                            set.remove(currentWord);
                        }
                        }
                         arr[ch] = current;
                    }
                   
                } 
            }
            wordCount++;
        }
        return 0;
    }
}

// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
//         //This will be considered as a graph problem
//         //The idea is to use a bfs approach where we start from beginword, visit all its neighbour and mark it. Say, we start from begin word hit, we need to travel through a word in which only one letter is changed, which in this case would be hot, hence we can consider hot to be a neighbour of hit and then we traverse to its neighbour using BFS
        
//        Set<String> set = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
        
//        if(!set.contains(endWord))
//            return 0;
        
//        Queue<String> queue = new LinkedList();
//        queue.offer(beginWord);
//        int count = 0;
        
//        while(!queue.isEmpty())
//        {
//            int size = queue.size();
           
//            while(size-->0)
//            {
//                String word = queue.poll();
               
               
               
//                if(word.equals(endWord))
//                    return count+1;
               
//                for(int c =0; c<word.length(); c++)
//                {
//                    char[] arr = word.toCharArray();
                   
//                    for(char ch = 'a'; ch<='z'; ch++)
//                    {
//                        if(word.charAt(c)==ch)
//                            continue;
                       
//                        arr[c] = ch;
                       
//                        String s = String.valueOf(arr);
//                        if(set.contains(s) && visited.add(s))
//                            queue.add(s);
//                    }
//                }
               
//            }
//            count++;
//        }
//         return 0;
//     }
//}

