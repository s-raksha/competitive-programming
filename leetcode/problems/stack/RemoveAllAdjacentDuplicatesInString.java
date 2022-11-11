/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class RemoveAllAdjacentDuplicatesInString {
    /*
    Time complexity o(n)
    space complexity o(n)
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char a:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == a)
                stack.pop();
            else
                stack.push(a);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.toString();
    }

}
