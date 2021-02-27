/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * 
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 */
class Solution {
    
    //Dry run for gas = 1,2,3,4,5 and cost = 3,4,5,1,2
    
    /*
    i = 0, totalFuel = -2 <0, totalGas =1, totalCost =3, index=1;
    i=1, totalFuel = 0+(-2) <0, totalGas=3, totalCost=7, index=2;
    i=2, totalFuel=0+(-2) <0, totalGas=6, totalCost=12, index=3;
    i=3, totalFuel=0+3 > 0, totalGas=10, totalCost=13, index=3
    i=4, totalFuel=3+3 > 0, totalGas=15, totalCost=15, index=3
    
    return index;
    */
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas=0;
        int totalCost=0;
        int totalFuel=0;
        int index=0;
        for(int i=0; i<gas.length; i++)
        {
            totalGas+=gas[i];
            totalCost+=cost[i];
            totalFuel+=gas[i]-cost[i];
            if(totalFuel<0)
            {
                index=i+1;
                totalFuel=0;
            }
            
        }
        
        if(totalGas<totalCost)
            return -1;
        else
            return index;
    }
}