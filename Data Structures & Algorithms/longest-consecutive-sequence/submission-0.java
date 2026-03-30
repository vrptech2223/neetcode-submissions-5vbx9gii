class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num :nums)
        {
            if(map.containsKey(num)) continue;
            int left = map.getOrDefault(num -1 , 0);
            int right = map.getOrDefault(num + 1 , 0);

            int sum = left + right + 1;

            map.put(num, sum);

            map.put(num - left  , sum);
            map.put(num + right , sum);

            max=Math.max(max,sum);
        }
        return max;
        
    }
}

