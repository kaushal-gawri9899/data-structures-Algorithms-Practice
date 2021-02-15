/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Input: num1 = "2", num2 = "3"
Output: "6"

 */

class Solution {
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] solution = new int[len1+len2];
        
        int carryForward = 0;
        
        for(int i=len1-1; i>=0; i--)
        {
            for(int j= len2-1; j>=0; j--)
            {
                
                //Make sure to remove
                int digit1 = num1.charAt(i)-'0';
                int digit2 = num2.charAt(j)-'0';
                
                //Make sure to multiply both the digits at last position and store that in solution array
                solution[i+j+1]+=digit1*digit2;
            }
        }
            
        
        //Now iterate over the solution array and get the value to be carryforwarded, increment the positions as    required
            
        for(int k = solution.length-1; k>=0; k--)
            {
                //This is the value to be kept at place k (which is the remainder)
                int temp = (solution[k]+carryForward)%10;
                //Updating the carryForward 
                carryForward = (solution[k]+carryForward)/10;
                solution[k] = temp;
            }
        
        //Now create the toReturn String and convert the elements in solution array to be a string
        StringBuilder toReturn = new StringBuilder();
        
        for(int digit : solution)
            toReturn.append(digit);
            
        while(toReturn.length()!=0 && toReturn.charAt(0)=='0')
            toReturn.deleteCharAt(0);
        
        if(toReturn.length()!=0)
        return toReturn.toString();
        else
            return "0";
        
    }
}