class Solution {

    List<String> solution = new ArrayList();
    HashMap<String,String> map = new HashMap<>();

    public List<String> letterCombinations(String digits)
    {

        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        if(digits.length()!=0)
        letterCombinationsHelper("",digits);        
        return solution;

    }

    //Input : "234"

    private void letterCombinationsHelper(String value, String currDigits)
    {
        if(currDigits.length()!=0)
        {
            String currDigit = currDigits.substring(0,1);
            String letter = map.get(currDigit);

            for(int i=0; i<letter.length(); i++)
            {
                String word = map.get(currDigit).substring(i,i+1);

               // currDigits.substring specifies next substring from Input
                letterCombinationsHelper(value+word, currDigits.substring(1));
            }
        }
        else{
            solution.add(value);
        }
    }
}