/**
 * In a deck of cards, each card has an integer written on it.
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * 
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 */
class Solution {
   
    //basic approach is to use an array or a hashmap and store  the count of all cards in the decks
    //Now as X>=2, we need to choose groups such that each group has atleast X cards in it given all cards in a group are similar
    //That is, we need to find if the count of each element is equal and greater than 1
    //This can be done using HCF, as HCF is the greatest common factor through which two numbers can be divided such that there remainder is zero, that is hcf for 4 and 2 = 2 whereas hcf for 3 and 9 would be 3
    //So, we need to check if there HCF is greater than 1
  

//Faster than using a hashMap
 public boolean hasGroupsSizeX(int[] deck){
        
     int[] map = new int[10000];
     
     for(int i=0; i<deck.length; i++)
     {
         map[deck[i]]++;
     }
     
     int totalHCF = 0;
     
     for(int hcf : map)
     {
         totalHCF = getHCF(hcf, totalHCF);
     }
     
     if(totalHCF > 1)
         return true;
     
     return false;
 }

//Implementation using hashMap
//      public boolean hasGroupsSizeX(int[] deck) {
    
//         Map<Integer, Integer> map = new HashMap<>();
    
//         for(int card : deck)
//         {
//             map.put(card, map.getOrDefault(card,0)+1);
//         }
    
//         int hcf =0;
    
//         for(int hcfCard : map.values())
//         {
//             hcf=getHCF(hcfCard, hcf);
//         }
        
//         if(hcf>1)
//             return true;
    
//         return false;
    
//     }


public int getHCF(int num1, int num2)
{
    if(num1==0)
        return num2;
    
    return getHCF(num2%num1, num1);
    
}
}