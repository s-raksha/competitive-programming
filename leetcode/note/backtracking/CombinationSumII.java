package backtracking;

/*
https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        targetSequence(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void targetSequence(int index, int[] arr, int target, List<List<Integer>> result, List<Integer> sub){
        if(target == 0){
            result.add(new ArrayList(sub));
            return;
        }
        for(int i=index; i<arr.length; i++){
            if(i > index && arr[i]==arr[i-1]) continue;
            if(arr[i] > target)
                break;
            sub.add(arr[i]);
            targetSequence(i+1, arr, target-arr[i], result, sub);
            sub.remove(sub.size()-1);
        }
    }
}
