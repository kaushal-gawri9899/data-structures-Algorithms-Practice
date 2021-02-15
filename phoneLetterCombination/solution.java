/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

class Solution {
    
    List<String> toReturn = new ArrayList<String>();
    HashMap<String, String> phoneDigits =  new HashMap<>();
    public List<String> letterCombinations(String digits) {
        
        //Use a map to store the mapping of each integer with string
        //Use a bactracking approach to check the digits, if there are no more digits to check           return the result List
        phoneDigits.put("2", "abc");
        phoneDigits.put("3", "def");
        phoneDigits.put("4", "ghi");
        phoneDigits.put("5", "jkl");
        phoneDigits.put("6", "mno");
        phoneDigits.put("7", "pqrs");
        phoneDigits.put("8", "tuv");
        phoneDigits.put("9", "wxyz");
        
        if(digits.length()!=0){
            backtrace("",digits);
        }
        
        return toReturn;
        
    }
    
    
    public void backtrace(String result, String leftDigits){
        
        if(leftDigits.length()!=0){
        String digits = leftDigits.substring(0,1);
        String letter = phoneDigits.get(digits);
        
        for(int i=0; i<letter.length(); i++){
            
            String word = phoneDigits.get(digits).substring(i,i+1);
            //append the combination by adding the string retrieved above which adds one of the letter from "letter" string to the next
            backtrace(result + word, leftDigits.substring(1));
        }
        }
        else {
            toReturn.add(result);
        }
    }
}