package array;
/*
https://leetcode.com/problems/minimum-average-difference/description/
 */
public class MinimumAverageDifference {
    /*
    Time complexity O(n)
    Space Complexity O(1)
     */
    public int minimumAverageDifference(int[] nums) {
        long sum = 0L;
        int size = nums.length;
        long minDiff = Long.MAX_VALUE;
        int result=0;
        long sumFrom0Index=0;
        long diff=0L;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        for(int i=0; i<nums.length-1; i++){
            sumFrom0Index+=nums[i];
            diff = Math.abs((sumFrom0Index/(i+1)) - ((sum-sumFrom0Index)/(size-i-1)));
            if(minDiff > diff){
                minDiff = diff;
                result = i;
            }
        }

        if(sum/size < minDiff){
            return size-1;
        }

        return result;
    }
}
