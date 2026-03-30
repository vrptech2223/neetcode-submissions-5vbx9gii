class Solution {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        for(char c:s.toCharArray())
        {
            if(c == '(' || c == '{' || c== '[')
            {
                stk.push(c);
            } else 
            {
                if(stk.isEmpty())
                {
                    return false;
                } else 
                {
                   char p= stk.pop();
                   if(c == ')' && p !='(')
                    return false;
                    else if(c == ']' && p !='[') 
                    return false;
                    else if(c == '}' && p !='{') 
                    return false;

                }

            }

            
        }
        return  stk.isEmpty();
    }
}
