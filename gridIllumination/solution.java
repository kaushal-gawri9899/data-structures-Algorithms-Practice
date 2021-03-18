/**
 * You are given a grid of size N x N, and each cell of this grid has a lamp that is initially turned off.
 * You are also given an array of lamp positions lamps, where lamps[i] = [rowi, coli] indicates that the lamp at grid[rowi][coli] is turned on. When a lamp is turned on, it illuminates its cell and all other cells in the same row, column, or diagonal.
 * Finally, you are given a query array queries, where queries[i] = [rowi, coli]. For the ith query, determine whether grid[rowi][coli] is illuminated or not. After answering the ith query, turn off the lamp at grid[rowi][coli] and its 8 adjacent lamps if they exist. A lamp is adjacent if its cell shares either a side or corner with grid[rowi][coli].
 * Return an array of integers ans, where ans[i] should be 1 if the lamp in the ith query was illuminated, or 0 if the lamp was not.
 *
 * Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * Output: [1,0]
 * Explanation: We have the initial grid with all lamps turned off. In the above picture we see the grid after turning on the lamp at grid[0][0] then turning on the lamp at grid[4][4].
 * The 0th query asks if the lamp at grid[1][1] is illuminated or not (the blue square). It is illuminated, so set ans[0] = 1. Then, we turn off all lamps in the red square.
 * The 1st query asks if the lamp at grid[1][0] is illuminated or not (the blue square). It is not illuminated, so set ans[1] = 0. Then, we turn off all lamps in the red rectangle.
 *
 */
class Solution {
 
    /*
    
    0 0 0 0
    0 0 0 0
    0 0 0 0
    0 0 0 0
    
    //lamps = [0,0] and [3,3]
    
    //queries = [1,1] and [1,0]
    
    //place a lamp at 0,0 so change 0 to 2
    
    2 0 0 0   
    0 0 0 0
    0 0 0 0
    0 0 0 0 
    
    Now, as 0,0 has a lamp we need to change all zeros in 0th row and 0th column to all 1. Also, we need to change all zeros in both the diagonals, left upper diagonal has values i-1,j-1 and right upper has i-1,j+1, left lower has values i+1,j-1 and right lower has i+1,j+1. We also need to check for up, down, left and right
    
    
    so, it becomes :
    
    2 1 1 1 
    1 1 0 0 
    1 0 1 1
    1 0 0 1
    
    After placing lamp at 3,3
    2 1 1 1 
    1 1 0 1
    1 0 1 1
    1 1 1 2
    
    Now, we check for query 1,1 , as it is 1 instead of 0, it is lit up, we turn it off and check in 8 directions and turn them back from 1 to 0
    Then, we check again for query 1,0, as it is 0, it is dark there, no need to do anything
    
    We return 1,0 because first query had lamp lit up so add 1 to array and next query had lamp off , so add 0
    
    We can create hashmaps to store count of all the adjacent value in same row, column, left and right diagonal
    */

public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    Map<Integer, Integer> row = new HashMap();   
    Map<Integer, Integer> column = new HashMap();   
    Map<Integer, Integer> leftDiag = new HashMap();     
    Map<Integer, Integer> rightDiag = new HashMap();       
    Set<Integer> state = new HashSet();
    
    // increment counters while adding lamps
    for(int[] l : lamps){
        int r = l[0];
        int c = l[1];
        row.put(r, row.getOrDefault(r, 0) + 1);
        column.put(c, column.getOrDefault(c, 0) + 1);
        leftDiag.put(r-c, leftDiag.getOrDefault(r-c, 0) + 1);
        rightDiag.put(r+c, rightDiag.getOrDefault(r+c, 0) + 1);
        state.add(N*r+c);
    }

       int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
    
    int[] solution = new int[queries.length];
 
    for(int i=0; i<queries.length; i++){
        int x = queries[i][0];
        int y = queries[i][1];
            
        if((row.containsKey(x)&&row.get(x)>0) || (column.containsKey(y) && column.get(y)>0) 
           || (leftDiag.containsKey(x-y)&&leftDiag.get(y)) ||(rightDiag.containsKey(x+y)&&rightDiag.get(x+y)))
            solution[i] = 1;
        else
            solution[i] = 0;

        for(int[] d : directions){
            int nextX = x+d[0];
            int nextY = y+d[1];
            
        
            if(state.contains(N*nextX+nextY)){
                row.put(nextX, row.getOrDefault(nextX, 1) - 1);
                column.put(nextY, column.getOrDefault(nextY, 1) - 1);
                leftDiag.put(nextX - nextY, leftDiag.getOrDefault(nextX - nextY, 1) - 1);
                rightDiag.put(nextX + nextY, rightDiag.getOrDefault(nextX + nextY, 1) - 1);
              
                state.remove(N*nextX+nextY);
            }
        }
    }
    
    return solution;
}
}

// class Solution {
//     public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        
        
//         /*
        
//         0 0 0 0
//         0 0 0 0
//         0 0 0 0
//         0 0 0 0
        
//         //lamps = [0,0] and [3,3]
        
//         //queries = [1,1] and [1,0]
        
//         //place a lamp at 0,0 so change 0 to 2
        
//         2 0 0 0   
//         0 0 0 0
//         0 0 0 0
//         0 0 0 0 
        
//         Now, as 0,0 has a lamp we need to change all zeros in 0th row and 0th column to all 1. Also, we need to change all zeros in both the diagonals, left upper diagonal has values i-1,j-1 and right upper has i-1,j+1, left lower has values i+1,j-1 and right lower has i+1,j+1. We also need to check for up, down, left and right
        
        
//         so, it becomes :
        
//         2 1 1 1 
//         1 1 0 0 
//         1 0 1 1
//         1 0 0 1
        
//         After placing lamp at 3,3
//         2 1 1 1 
//         1 1 0 1
//         1 0 1 1
//         1 1 1 2
        
//         Now, we check for query 1,1 , as it is 1 instead of 0, it is lit up, we turn it off and check in 8 directions and turn them back from 1 to 0
//         Then, we check again for query 1,0, as it is 0, it is dark there, no need to do anything
        
//         We return 1,0 because first query had lamp lit up so add 1 to array and next query had lamp off , so add 0
        
//         We can create hashmaps to store count of all the adjacent value in same row, column, left and right diagonal
//         */
        
        
//         HashMap<Integer, Integer> row = new HashMap<>();
//         HashMap<Integer, Integer> column = new HashMap<>();
//         HashMap<Integer, Integer> leftDiag = new HashMap<>();
//         HashMap<Integer, Integer> rightDiag = new HashMap<>();
//         Set<Integer> state = new HashSet<>();
        
        
//         for(int l[] : lamps)
//         {
//             int r = l[0];
//             int c = l[1];
            
//             row.put(r, row.getOrDefault(r,0)+1);
//             column.put(c, row.getOrDefault(c,0)+1);
//             leftDiag.put(r-c, row.getOrDefault(r-c,0)+1);
//             rightDiag.put(r+c, row.getOrDefault(r+c,0)+1);
            
//             state.add(N*r+c);
//         }
        
//         int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}, {0,0}};
        
// //         int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
        
//         int[] solution = new int[queries.length];
        
//         //Now we check for all the queries and all the directions
        
        
//         for(int i=0; i<queries.length; i++)
//         {
//             int x = queries[i][0];
//             int y = queries[i][1];
            
//             //Check if there's already a lamp at queried position, we just convert it to 1 instead as it cannot be turned off
//             if(row.getOrDefault(x,0)>0 || column.getOrDefault(y,0)>0 || leftDiag.getOrDefault(x-y,0)>0 || rightDiag.getOrDefault(x+y,0)>0)
//                 solution[i] = 1;
//             else
//                 solution[i] = 0;
 
            
//             //Now, we check if there are any lamps to be switched off in all 8 adjacent positions
//             for(int[] d: directions)
//             {
//                 int nextX = x+d[0];
//                 int nextY = y+d[1];
//                 //We decrement the counters for all the positions
//                 //We need to check if the lamp is turned on, so check our set if it contains the current lamp with given id N*nextX+nextY
//                 if(state.contains(N*nextX+nextY))
//                 {
// //                 row.put(nextX, row.getOrDefault(nextX,1)-1);
// //                 column.put(nextY, column.getOrDefault(nextY,1)-1);
// //                 leftDiag.put(nextX-nextY, leftDiag.getOrDefault(nextX-nextY,1)-1);
// //                 rightDiag.put(nextX+nextY, rightDiag.getOrDefault(nextX+nextY,1)-1);
                
// //                 //Change the state in our set to off
// //                 state.remove(N*nextX+nextY);
                    
//                     row.put(nextX, row.getOrDefault(nextX, 1) - 1);
//                     column.put(nextY, column.getOrDefault(nextY, 1) - 1);
//                     leftDiag.put(nextX - nextY, leftDiag.getOrDefault(nextX - nextY, 1) - 1);
//                     rightDiag.put(nextX + nextY, rightDiag.getOrDefault(nextX + nextY, 1) - 1);
//                     //.put(N*x1+y1, false);
//                     state.remove(N*nextX+nextY);
//                 }
//             }
//         }
        
//         return solution;
//     }
// }