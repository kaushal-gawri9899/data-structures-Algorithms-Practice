/**
Input: s = "III"
Output: 3
 */

class Solution {
    public int romanToInt(String s) {
        
     Map<Character, Integer> romanVal = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100,                                                      'D', 500, 'M', 1000);
        
    int value = 0;
        
    //Algorithm
    //Start iterating the string from the end
    //Store the value already added in map
    //Check if this value is less than the value of char at i+1 position of string in map
        //If yes, subtract this value from the value to be returned 
        //else, add this value in value to be returned
    for(int i=s.length()-1; i>=0; i--){
        
        int currValue = romanVal.get(s.charAt(i));
        
        if(i<s.length()-1 && currValue < romanVal.get(s.charAt(i+1))){
            value = value-currValue;
        }
        else {
            value = value + currValue;
        }
        
    }
        return value;
    }
}