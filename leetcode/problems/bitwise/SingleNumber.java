package bitwise;
/*
https://leetcode.com/problems/single-number/description/
 */
public class SingleNumber {

    /*
    Time complexity o(n)
    space complexity o(1)
    using xor
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length ; i++){
            result^=nums[i];
        }
        return result;
    }
}
