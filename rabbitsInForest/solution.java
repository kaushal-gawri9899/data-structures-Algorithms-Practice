/**
 * 
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 * Return the minimum number of rabbits that could be in the forest.
 * 
 * Input: answers = [1, 1, 2]
 * Output: 5
 */
class Solution {
    
    public int numRabbits(int[] answers)
    {
        
        HashMap<Integer, Integer> rabbits = new HashMap<Integer, Integer>();
        
        int minNumber = 0;
        
        for(int i : answers)
        {
            if(i==0)
            {
                minNumber+=i+1;
                continue;
            }
            
            if(!rabbits.containsKey(i))
            {
                //If we didn't considered this rabbit yet, we put this rabbit in our map with value 0 and increase the count. (i+1 because we need to consider this rabbit along with the number of rabbits similar to this rabbit)
                rabbits.put(i,0);
                minNumber+=i+1;
            }
            
            else{
                
                //If the value i is already present, that is if already some rabbit said that there are i rabbits similar to its color, we increase the count of that color.
                //Also, we check if the count is equal to the number of rabbit similar that current rabbit said, if they both are similar we remove that i as then every rabbit of this color is already present and counted above, thus we remove them to allow the change to account for others
                rabbits.put(i, rabbits.get(i)+1);
                
                if(rabbits.get(i)==i)
                {
                    rabbits.remove(i);
                }
                    
            }
            
         
        }
           return minNumber;
    }
//     public int numRabbits(int[] answers) {
        
//         /*
//         The questions asks us to find minimum number of rabbits
//         We have an array of answers which probably are the number of rabbits with a particular color, lets see example 1 1 2
        
//         So, in this case lets say rabbit 0 says there's only other rabbit with same color and rabbit 1 also says that there's only one other rabbit with the same color. Assuming they both are talking about each other we can say that there are two rabbits of color A
        
//         Now, rabbit 2 says that there are 2 more rabbits that share the same color as him/her. Now, the rabbit that answered two cannot be of color A (as total color A rabbits are atmost 2)
//         Say, the rabbit 2 that said 2 is of color B. Now, as there are two more rabbits of color B, total rabbits of color B would be 3
        
//         So, total number of rabbits in forest = 2 + 3 = 5
//         */
        
//         /*
//         Now, we can use a hashmap to define the count of rabits for each color
//         */
        
//         HashMap<Integer, Integer> rabbits = new HashMap<>();
        
//         int minNumber = 0;
//         for(int i : answers)
//         {
//             /*
//             1 1 2
            
//             Now, currVal would be either 0 or values associated with i+1 which is 2
//             As our map is empty for now, currVal = 0
//             We increase minNumber to be equal to i+1, thus minNumber =2
//             We update our currVal to be i+1 = 2 as well
            
//             Now, we decrease our currVal back to 1, associated with 1 and put inside our map (1+1,1) = (2,1)
            
//             In the next case, currVal = 1. As, i+1 is already present.
//             We reduce our currVal to zero and update it to (2,0)
            
//             Now, we have currVal again = 0 as 2+1, 3 isn't present in our map
//             Thus, we increase our minumber from 2 to 2+i+1 = 2+2+1 = 5
//             And update our current value to be equal to i+1 =3
//             We reduce our currvalue and put (3,2) in our map
//             */
//            int currVal = rabbits.getOrDefault(i+1,0);
           
//            if(currVal==0)
//            {
//                 minNumber = minNumber+i+1;
//                 currVal = i+1;   
//            }
//            --currVal;
        
//            rabbits.put(i+1,currVal);
           
//            //We initially put the count of rabbits of particular color in our map such that say if a value already doesn't exist in map, we get currVal = 0 (if exists, currVal would be that values). If currVal==0, this means that it is one type of rabbit and if it says there are multiple rabbits of that type, our minNumber would now be currValue+1
            
//           //Now, we need now put the value in our map such that we have key = i and value to be currVal+1 % i+1  (As, say i = 1 and currVal = 0, we increase minNumber to 2 and add 1%2 which is 0 to our value in map)
//           // rabbits.put(i, )
           
//         }
    
//         return minNumber;
//     }
}