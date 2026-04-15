class Solution {
    public String longestPalindrome(String s) {

        int rl = 0 , ri=0;

        for(int i=0;i<s.length();i++)
        {

            int l=i,r=i;
            while(l>=0 && r <s.length() && s.charAt(l) == s.charAt(r))
            {
                if(r - l +1 > rl)
                {
                    ri = l ;
                    rl = r - l + 1;
                }
                l--;
                r++;
            }

            l=i;
            r=i+1;
            while (l >= 0 && r < s.length() &&
                   s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > rl) {
                    ri = l;
                    rl = r - l + 1;
                }
                l--;
                r++;
            }

        }

         return s.substring(ri, ri + rl);
    }
}
