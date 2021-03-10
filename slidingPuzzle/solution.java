/**
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        
        /*
        1 2 3  ---> 1 2 3
        4 0 5       4 5 0
        1 swap to get the output
        
        1 2 3 -----> 1 2 3
        5 4 0 -----> 5 4 0
        -1 swap to get the output as zero is on its correct position
        
        4 1 2 ------> 4 1 2 ------> 0 1 2 -----> 1 0 2 -----> 1 2 0 -----> 1 2 3
        5 0 3 ------> 0 5 3 ------> 4 5 3 -----> 4 5 3 -----> 4 5 3 -----> 4 5 0
        Total swaps = 5 as shown in dry run
        
        */
        
        /*
        Should be solved using BFS as it asks for minimum number of swaps
        We can add the position of 0 in our queue to start with
        Now, using BFS, we can get the neighbours and check is swapping it with current position of zero will make it either closer or probably on its respective position (which can be taken a record of using another 2d grid where we add the positions at which zero could be swapped)
        This will be continued until zero ends up at its correct position
        
        Consider having a string = "123450" which will be used to manage indices for each value
        */
        
        //The rows of our directions array determine the position at which 0 is and the two values determine the positions where 0 can be swapped in our string "123450"
        int[][] directions = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        
        //Now we will create our new string which is mapped through our board
        
        String initial = "123450";
        String current = "";
        
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                current+=board[i][j];
            }
        }
        
        // if(initial.equals(current))
        //     return 0;
        
        //Now, this problem can be treated similar to k similar strings
        
        Queue<String> queue = new LinkedList();
        Set<String> visitedSet = new HashSet<String>();
        
        queue.offer(current);
        visitedSet.add(current);
        
        int moves = 0;
        
        while(!queue.isEmpty())
        {
            
            int size = queue.size();
            while(size-- > 0)
            {
                String curr = queue.poll();
                
                if(curr.equals(initial))
                {
                    return moves;
                }
                
                int zeroIdx = curr.indexOf('0');
      
                for(int i=0; i<directions[zeroIdx].length; i++)
                {
                     String temp = swapPositions(curr,zeroIdx,directions[zeroIdx][i]);
                    
                     if(!visitedSet.contains(temp))
                     {
                         visitedSet.add(temp);
                         queue.offer(temp);
                     }
                }
                
            }
            moves++;
        }
        
        return -1;
        
    }

    private String swapPositions(String curr, int zeroIdx, int i)
    {
        char[] c = curr.toCharArray();
        char temp = c[zeroIdx];
        c[zeroIdx] = c[i];
        c[i] = temp;
        
        return new String(c);
    }

}