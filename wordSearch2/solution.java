/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */


 class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        //Backtracking should be used for all the four directions
        
        //boolean flag = false;
        //we define some relevant directions which can either be North, south, east or west
        // up : i-1, down: i+1; left: j-1; right: j+1
        
        List<String> wordsPresent = new ArrayList<>();
        for(String word : words)
        {
            if(exist(board,word))
                wordsPresent.add(word);
        }
        
        return wordsPresent;
     
    }
    
     private boolean exist(char[][] board, String word) {
        
       
        //Backtracking should be used for all the four directions
        
        //boolean flag = false;
        //we define some relevant directions which can either be North, south, east or west
        // up : i-1, down: i+1; left: j-1; right: j+1
        
        int row = board.length;
        int column = board[0].length;
        
        boolean[][] marked = new boolean[row][column];
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<column; j++)
            {
                if(searchLetter(board,word,i,j,0,marked)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean searchLetter(char[][] board, String word, int i, int j, int index, boolean[][] marked)
    {
        if(index==word.length())
            return true;
        
        if(i>=board.length  || i<0 || j>=board[i].length || j<0 || board[i][j] !=word.charAt(index) || marked[i][j])
            return false;
        
        //Mark the index you are checking
        marked[i][j] = true;
        
        //Now recursively search for letter on all four directions
        //index + 1 states the next letter in "word"
        if(searchLetter(board,word,i-1,j,index+1,marked) || searchLetter(board,word,i+1,j,index+1,marked) ||                            searchLetter(board,word,i,j-1,index+1,marked) || searchLetter(board,word,i,j+1,index+1,marked) )
        {
            return true;
        }
        
        //Unmark the position
        //Backtrack
        marked[i][j] = false;
        
        return false;
        
        
    }

}