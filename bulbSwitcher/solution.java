/**
 * There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Return the number of bulbs that are on after n rounds.
 */
class Solution {
    public int bulbSwitch(int n) {
        
        /*
        Problem statement : We can toggle each ith bulb for each ith move
        
        For example : If for first move, i=1, we can toggle each bulb from off to on
                    For every second round, we can toggle each second bulb
                    For every third round, we can toggle each 3rd bulb
                    
        Now, say for 1st round : we turn on each bulb, so bulb 1 can only be turned on in this case
        For 2nd round: we turn off each 2nd bulb, which includes, factors of 2,i.e, 2,4,6..
        For 3rd round : we toggle each 3rd bulb, which includes, factors of 3, i.e, 3,6,9
        Now, common factors of 2 and 3 would be first off in round 2 and then again on in round 3
        
        Now for 4th round : we toggle each 4th bulb, which includes, factors of 4, i.e, 4,8,12,16..
        We can see that 4 can occur thrice in the whole operation, for 1st round, for 2nd round (as 2 is a factor of 4) and for 4th round.
        For any other perfect square, the buld will appear only thrice, for 1st round, for round who's perfect square that number is and for its own round
        
        For ith round : we toggle each ith buld, which includes, factors of i, i.e, i,2i,3i,4i....
        
        Thus, only the bulbs that are perfect square, like, 1,4,9,16 etc will be turned on because only they will be toggled for odd number of times
        
        */
        
        return (int)Math.sqrt(n);
    }
}