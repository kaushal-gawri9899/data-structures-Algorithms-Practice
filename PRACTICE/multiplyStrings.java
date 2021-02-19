class Solution {
    
    public String multiply(String num1, String num2) {
    
        int end1 = num1.length();
        int end2 = num2.length();

        int[] array = new int[end1+end2];
        for(int i=end1-1; i>=0; i--)
        {
            for(int j=end2-1; j>=0; j--)
            {
                int digit1 = num1.charAt(i);
                int digit2 = num1.charAt(j);

                array[end1+end2+1]+=digit1*digit2;

            }
        }


        int carryForward = 0;

        for(int i=array.length-1; i>=0; i--)
        {
            int temp = (array[i]+carryForward)%10;
            carryForward = (array[i]+carryForward)/10;
            array[i] = temp;
        }
    
        StringBuilder s = new StringBuilder();
        
        for(int value : array)
        {
            s.append(value);
        }

        while(s.length()!=0 && s.charAt(0)=='0')
        {
            s.deleteCharAt(0);
        }

        if(s.length()!=0)
        return s.toString();
        else
        return "0";
    }


}
