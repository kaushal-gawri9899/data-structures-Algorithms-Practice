/**
 * Given an integer, convert it to a roman numeral.
 * Input: num = 3
 * Output: "III"
 * Input: num = 9
 * Output: "IX"
 */
class Solution {
    public String intToRoman(int num) {
        
        String[] romanVal = {"M","CM","D","CD", "C","XC","L","XL","X","IX","V","IV","I"};
        
        int[] integerVal = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        /*
        Basically we need to iterate until the current number becomes zero
        Also, we make a loop to append our stringbuilder such that the number is greater than or equal to the current value in integerVal. If true and inside loop, we update the value of num by decreasing the integerVal[i] from it (such that num = 3--->2---->1--->0 we break the loop now and three "I" are added to our stringbuilder )If not true, we increase the counter for our integerVal.
        */
        
        int i=0;
        
        StringBuilder sb = new StringBuilder();
        while(num>0)
        {
            while(num>=integerVal[i])
            {
                num = num - integerVal[i];
                sb.append(romanVal[i]);
                
            }
            i++;
        }
        
        return sb.toString();
        
    }
}