class Solution {
    public boolean isAnagram(String s, String t) {

        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s1.length;i++)
        {
               m.put(s1[i],m.getOrDefault(s1[i],0)+1);
        }  
               for(int i=0;i<s2.length;i++)
        {
            if( m.getOrDefault(s2[i],0)-1 ==0 )
            m.remove(s2[i]);
                else
               m.put(s2[i],m.getOrDefault(s2[i],0)-1);
        }  
        return m.isEmpty();  
    }
}
