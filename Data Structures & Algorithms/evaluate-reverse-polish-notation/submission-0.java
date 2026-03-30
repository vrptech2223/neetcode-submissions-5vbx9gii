class Solution {
    public int evalRPN(String[] tokens) {

   Stack<Integer> val = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                int b = val.pop(); // second operand
                int a = val.pop(); // first operand

                if (s.equals("+")) {
                    val.push(a + b);
                } else if (s.equals("-")) {
                    val.push(a - b);
                } else if (s.equals("*")) {
                    val.push(a * b);
                } else {
                    val.push(a / b);
                }

            } else {
                val.push(Integer.valueOf(s));
            }
        }

        return val.peek();
    }
}
