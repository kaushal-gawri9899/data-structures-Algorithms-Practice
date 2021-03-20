/**
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 */
class Solution {
    
    /*Solution using heap*/
//     public int kthSmallest(int[][] matrix, int k)
//     {
//         /*
//         This problem is similar to merge k sorted list
//         We can use a heap to maintain the each row or columns, to start with we add the elements from first row and we do it for k-1 times
//         Every time we remove the top element, we remember its row and column and increase the count, If we find count ==k, we return the row and column saved of pq.poll and return the element at that position
//         */
        
//         int count = 0;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//         k, (a,b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        
//         pq.offer(new int[]{0,0});
        
        
//         while(true)
//         {
//             int[] top = pq.poll();
//             count++;
            
//             if(count==k)
//                 return matrix[top[0]][top[1]];
            
//             //For first row and columns in bound
//             if(top[0] == 0 && top[1]+1 < matrix[0].length)
//                 pq.offer(new int[]{0, top[1]+1});
            
//             //For rest of the rows, check the bounds
//             if(top[0]+1 < matrix.length)
//                 pq.offer(new int[] {top[0]+1, top[1]});
//         }
        
//     }
    
    public int kthSmallest(int[][] matrix, int k) {
        
        /*
        1  5  9
        10 11 13
        12 13 15
        
        This problem is similar to merge k sorted list
        We can use a heap to maintain the each row or columns and we do it for k-1 times
        Every time we remove the top element, we remember its row and column
        Another approach is using binary search
        */
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;   
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = matrix[0][0];
        int end = matrix[row-1][col-1];
        
        while(start<end)
        {
            int mid = start + (end-start)/2;
            
            int count = count(matrix,mid,row,col);
            
            if(count<k)
                start = mid+1;
            
            else
                end = mid;
            
        }
        
        return start;
        
        
    }
    
    private int count(int[][] matrix, int mid, int row, int col)
    {
        int count = 0;
        int j = col-1;
        
        for(int i=0; i<row; i++)
        {
            while(j>=0 && matrix[i][j]>mid)
                j--;
            
            count+=j+1;
        }
        
        return count;
    }
}