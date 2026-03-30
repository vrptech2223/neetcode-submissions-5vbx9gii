class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] i1=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int diff = target - nums[i];
            if(m.containsKey(diff)){
            i1[0]=m.get(diff);
            i1[1]=i;}
            else {
            m.put(nums[i],i);
            }
        }
        return i1;
        
    }
}
