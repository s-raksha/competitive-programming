package backtracking;
/*
https://leetcode.com/problems/subsets-ii/description/
 */
public class SubsetsII {

    /*
    Pick (same index until target is greater than zero) not-pick
    Time complexity O(2^n * k)+ nlogn ========> O(2^n * k)
    Space complexity O(2^n * k)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(0,nums, result, new ArrayList<>());
        return result;
    }

    private void subset(int index, int[] nums, List<List<Integer>> result, List<Integer> sub){
        result.add(new ArrayList<>(sub));
        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i] == nums[i-1]) continue;
            sub.add(nums[i]);
            subset(i+1, nums, result, sub);
            sub.remove(sub.size()-1);
        }
    }
}
