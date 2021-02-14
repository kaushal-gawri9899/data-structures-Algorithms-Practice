/** 
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        
        //The basic approach is to maximise the difference between two elements of the price array
        //Make sure sum = A[j] - A[i] >>>> such that j > i
        //Try to do it in linear or log time else time limit will exceed (using single pass)
        
        
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++)
        {
        //     for(int j=i+1; j< prices.length; j++)
        //     {
        //         sum = Math.max(sum, (prices[j]-prices[i]));
        //     }
        // }
            
                if(prices[i] < minSum)
                    minSum = prices[i];
                else if(prices[i] - minSum > sum)
                    sum = prices[i] - minSum;
        }
        
       return sum;
    }
}