class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l= 0;
        int max=0;
        Set<Character> se=new HashSet<>();
       for(int r=0;r < s.length() ; r++)
        {
            while (se.contains(s.charAt(r))) {
                se.remove(s.charAt(l));
                l++;
            }

            se.add(s.charAt(r));
            max=Math.max(max,r-l+1);

        }

        return max;
        
    }
}
