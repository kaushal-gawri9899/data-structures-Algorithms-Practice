/** 
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
* You have the following three operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
*
* Input: word1 = "horse", word2 = "ros"
* Output: 3
* Explanation: 
* horse -> rorse (replace 'h' with 'r')
* rorse -> rose (remove 'r')
* rose -> ros (remove 'e')
*/
class Solution {
    public int minDistance(String word1, String word2) {
        
        //This can be solved using DP
        //We need to consider three case, when inserting a char, deleting a char or replacing a char
        
        /* DP TABLE
        
            h o r s e               r o s
          0 1 2 2 3 4             0 1 2 3
        r 1 1 2 2 3 4           h 1 1 2 3
        o 2 2 1 2 3 4           o 2 2 1 2
        s 3 3 3 2 2 3           r 3 2 2 2
                                s 4 3 3 2
                                e 5 4 4 3
                            
        */
        
        // Construct DP table array and mark 1 row and 1 column = i=j
        // Check if any one string is empty, insert every character from another string to it(2                 cases)
        
        // Check if char at pos i-1 of word 1 is equal to char at pos j-1
            // Choose the upward diagonal solution which is 0,0 for pos 1,1, that is dp[i-1][j-1]
        
        // Check if char different, dp[i][j] would be the minimum of upward diagnoal, element at same column but row above, element at same row but columb left, i,e 
        // dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
        
        //after all iterations in dp, return dp[row-1][col-1] or dp[length of word1][length of word2]
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i=0; i<=len1; i++)
        {
            for(int j=0; j<=len2; j++)
            {
                //Filling first row of table
                if(i==0)
                  dp[i][j] = j;
                
                //Filling first column of table
                else if(j==0)
                    dp[i][j] = i;
                
                //If the words at last position of word2 is same 
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                
                else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
                
            }
        }
        
        return dp[len1][len2];
    }
}