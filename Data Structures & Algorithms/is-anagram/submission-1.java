class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
               m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }  
               for(int i=0;i<t.length();i++)
        {
            if( m.getOrDefault(t.charAt(i),0)-1 ==0 )
            m.remove(t.charAt(i));
                else
               m.put(t.charAt(i),m.getOrDefault(t.charAt(i),0)-1);
        }  
        return m.isEmpty();  
    }
}
