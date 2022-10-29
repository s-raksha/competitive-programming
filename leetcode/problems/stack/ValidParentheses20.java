class Solution {
    /*
    Time complexity o(n)
    space complexity o(n)
     */
    public boolean isValid(String s) {
        Stack<Character> parantheseStack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c =='(')
                parantheseStack.push(')');
            else if (c == '[')
                parantheseStack.push(']');
            else if (c == '{')
                parantheseStack.push('}');
            else if(parantheseStack.isEmpty() || parantheseStack.pop() != c)
                return false;
        }
        return parantheseStack.isEmpty();
    }
}