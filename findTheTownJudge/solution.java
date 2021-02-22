/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * 
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 */

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        //Graph problem in which we need to return the vertex which is connected by every other node or else return -1
        
        //The vertex who's in degree is equal to n-1 or out degree is 0 is the solution
        
        int[] degreeIn = new int[N+1];
        int[] degreeOut = new int[N+1];
        
        for(int[] arr : trust)
        {
            int p1 = arr[0];
            int p2 = arr[1];
            
            //Here as p1 trusts p2, p1 outdegree is 1 and p2 in degree is 1
            //Now our answer would be the vertex whose either inDegree is N-1 and outDegree =0
            degreeOut[p1]+=1;
            degreeIn[p2]+=1;
        }
        
        int index = -1;
        
        for(int i=1; i<=N; i++)
        {
            if(degreeIn[i]==N-1 && degreeOut[i]==0)
                index = i;
        }
            
        return index;
    }
}