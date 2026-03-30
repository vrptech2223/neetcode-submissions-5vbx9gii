class Solution {
    public boolean isPalindrome(String s) {

        s=s.toLowerCase();
        char[] ca=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i <= j)
        {
            if(!Character.isLetterOrDigit(ca[i]))
            {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(ca[j]))
            {
                j--;
                continue;
            }
            if(ca[i]==ca[j])
            {
                i++;
                j--;
            }else 
            {
                return false;
            }   


        }
        
        return true;
    }
}
