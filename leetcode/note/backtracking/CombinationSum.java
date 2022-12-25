package backtracking;

/*
https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    /*
    Pick (same index until target is greater than zero) not-pick
    time complexity 2^t*k (t= target, k average size of combination)
    space complexity k*x (k = average size of combination, x- number of combination)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationRecursion(0,candidates, target, new ArrayList<>());
        return result;
    }
    private void combinationRecursion(int index, int[] candidates, int target, List<Integer> subArray) {

        if (target == 0) {
            result.add(new ArrayList(subArray));
            return;
        }
        if (index >= candidates.length)
            return;

        if (target > 0) {
            subArray.add(candidates[index]);
            combinationRecursion(index, candidates, target - candidates[index], subArray);
            subArray.remove(subArray.size() - 1);
        }
        combinationRecursion(index + 1, candidates, target, subArray);
    }
}
