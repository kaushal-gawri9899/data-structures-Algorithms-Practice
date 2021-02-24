/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 */
class Solution {
    public int numSquares(int n) {
        
        // Queue<Integer> squares = new LinkedList();
        LinkedList<Integer> squares = new LinkedList();
        
        HashSet<Integer> visited = new HashSet<Integer>();
        
        //squares.offer(0);
        squares.add(0);
        visited.add(0);
        int end = 0;
        //while(!squares.isEmpty())
        while(squares.size()>0)
        {
            int size = squares.size();
            end++;
            
            while(size>0)
            {
                int elem = squares.poll();
                // 1 , 4 , 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169 ....
                for(int i=1; i*i<=n; i++)
                {
                    int value = elem+i*i;
                    
                    if(value==n)
                        return end;
                    
                    if(value>n)
                        break;
                    
                    if(!visited.contains(value))
                     {
                        squares.add(value);
                        visited.add(value);
                     }  
                }
                size--;
                
            }
        }
        
        return end;
        
        //Using the same logic but starting from the end of the linkedlist
//         LinkedList<Integer> squares = new LinkedList();
//         HashSet<Integer> visited = new HashSet<>();
        
//         squares.add(n);
        
//         for(int index=0; !squares.isEmpty(); index++)
//         {
//             for(int i=squares.size(); i>0; i--)
//             {
//             int value = squares.poll();
//             if(value==0)
//                 return index;
            
//             for(int j=1; j*j<=value; j++)
//             {
//                 if(visited.add(value-j*j))
//                 {
//                     //visited.add(value-j*j);
//                     squares.offer(value-j*j);
//                 }
//             }
//             }
//         }
//         return 0;
    }
}