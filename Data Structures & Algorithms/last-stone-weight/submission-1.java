class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones)
        {
            maxHeap.offer(num);
        }

        while(maxHeap.size() > 1 )
        {
            int m1=maxHeap.poll();
            int m2=maxHeap.poll();
            if(m1>m2)
            {
                maxHeap.offer(m1-m2);
            }
        }
        maxHeap.offer(0);
        return maxHeap.peek();
    }
}
