/*
https://leetcode.com/problems/steps-to-make-array-non-decreasing/description/
 */
public class StepsToMakeArrayNon_decreasing {

    /*
    Time complexity o(n)
    space complexity o(n)
    Monotonic stack maintain the order and array to store no of passes (element removal to make array in order)
     */
    public int totalSteps(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] pass = new int[nums.length];
        int maxPass=0;
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                pass[i] = Math.max(pass[i] + 1, pass[stack.pop()]);
            }
            stack.push(i);
            maxPass = Math.max(pass[i], maxPass);
        }
        return maxPass;
    }
}
