/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Input: nums = [10,2]
 * Output: "210"
 */
class Solution {
    public String largestNumber(int[] nums) {
        
        
        String[] numsArray = new String[nums.length];
        
        for(int i=0; i<nums.length; i++)
        {
            numsArray[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> c = new Comparator<String>(){
            
            @Override
            public int compare(String s1, String s2)
            {
                String a = s1+s2;
                String b = s2+s1;
                
                //The order matters
                //Reverse order is used here such that we can append to our string builder later
                return b.compareTo(a);
            }
        };
        
        Arrays.sort(numsArray,c);
        
        //An edge case where we have a few zeros in our array
        if(numsArray[0].charAt(0)=='0')
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : numsArray)
        {
            sb.append(s);
        }
        
        return sb.toString();
    }
}