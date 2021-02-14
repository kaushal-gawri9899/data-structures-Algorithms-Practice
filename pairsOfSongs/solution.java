// You are given a list of songs where the ith song has a duration of time[i] seconds.

// Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int counter=0;
        Map<Integer, Integer> timeMap= new HashMap();
        
        for(int arr : time){
            if(arr%60==0)
                counter+=timeMap.getOrDefault(0,0);
            else
                counter+=timeMap.getOrDefault(60-arr%60, 0);
            
            timeMap.put(arr%60, timeMap.getOrDefault(arr%60,0) + 1);
    }
        
        return counter;
}
}