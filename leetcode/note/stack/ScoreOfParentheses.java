/*
https://leetcode.com/problems/score-of-parentheses/
 */
public class ScoreOfParentheses {
    /*
    Time complexity o(n)
    Space complexity o(n)
    1. push score to stack and reset when ever '(' is found
    2. ')' calculate the score
     */
    public int scoreOfParentheses(String s) {
        Stack<Integer> scoreStack = new Stack<>();
        int score = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                scoreStack.push(score);
                score = 0;
            }else{
                score = scoreStack.pop() + Math.max(2*score,1);
            }
        }
        return score;
    }
}
