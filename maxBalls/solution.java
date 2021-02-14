// You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit inclusive (i.e., n == highLimit - lowLimit + 1), and an infinite number of boxes numbered from 1 to infinity.

// Your job at this factory is to put each ball in the box with a number equal to the sum of digits of the ball's number. For example, the ball number 321 will be put in the box number 3 + 2 + 1 = 6 and the ball number 10 will be put in the box number 1 + 0 = 1.

// Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] box = new int[46];
        
        for(int i=lowLimit; i<=highLimit; i++){
            int sum = 0;
            int var = i;
            
            while(var>0){
                sum = sum + var%10;
                var = var/10;
            }
            box[sum]+=1; 
        }
        
        int high = 0;
        for(int i=0; i<46; i++){
            if(box[i]>high){
                high=box[i];
            }
        }
        
        return high;
    }
}