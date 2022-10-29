package stack;
/*
Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a
result, and there will not be any division by zero operation.
 */

class Solution {
    /*
    Using set and stack
    Time complexity 0(n)
    Space complexity 0(n)
    set to store operation
     */
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet(Arrays.asList("+","-","*","/"));
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(set.contains(s)){
                if(s.equals("+")){
                    stack.push(stack.pop()+stack.pop());
                }else if(s.equals("-")){
                    int a=stack.pop();
                    int b=stack.pop();
                    stack.push(b-a);
                }else if(s.equals("*")){
                    stack.push(stack.pop()*stack.pop());
                }else if(s.equals("/")){
                    int a=stack.pop();
                    int b=stack.pop();
                    stack.push(b/a);
                }

            }else
                stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }
}