package array;

/*
Set Mismatch

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss
of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
class SetMismatch {
    /*
    modifying same array
    space complexity o(1)
    time complexity o(n)
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int i=0;

        while(i < nums.length){

            int idx = nums[i] - 1;

            if(nums[i] != nums[idx]){
                swap(i, idx, nums);
            }
            else
                ++i;
        }

        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                result[0] = nums[i];
                result[1] = i+1;
            }

        }
        return result;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

     /*
    modifying same array
    space complexity o(1)
    time complexity o(n)
     */
     public int[] findErrorNums(int[] nums) {
         int[] result = new int[2];
         int sum=0;
         Set<Integer> hashSet = new HashSet<>();
         for(int i=0; i<nums.length; i++){
             sum+=nums[i];
             if(!hashSet.add(nums[i])){
                 result[0] = nums[i];
             }
         }
         result[1] = (nums.length * (nums.length+1)/2)+result[0] - sum;
         return result;
     }
}