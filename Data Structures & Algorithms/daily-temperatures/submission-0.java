class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack();
        int[] res = new int[temperatures.length];
        for(int i=0;i < temperatures.length ; i++)
        {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()])
            {
                int r = i - s.peek() ;
                res[s.peek()] = r;
                s.pop();
            }
                s.push(i);
        

            System.out.println(s);
        }

        return res;
        
    }
}
