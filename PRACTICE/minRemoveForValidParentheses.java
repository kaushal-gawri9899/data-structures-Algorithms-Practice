class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int closeBracket =0;
        int count = 0;
        int len = s.length();
        
        for(int i=0; i<len; i++)
        {
            char ch = s.charAt(i);
            if(ch==')')
                closeBracket++;
        }
        
        StringBuilder sb = new StringBuilder();
     
        for(int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                if(count==closeBracket)
                    //It will help us in skipping unnecessary ( brackets
                    continue;
                count++;
            }
            if(c==')')
            {
                closeBracket--;
                if(count==0)
                    //It will help us in skipping unnecessary ) brackets
                    continue;
                count--;
                    
            }
            sb.append(c);
        }
        
        return sb.toString();
        
    }
}