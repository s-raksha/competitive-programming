/*
https://practice.geeksforgeeks.org/problems/subset-sums2234/1
 */
public class SubsetSums {

    /*
    take not take
    Time complexity O(2^n)
    Space complexity O(2^n)
     */
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        sum(0,arr,result,0);
        return result;
    }

    private void sum(int index, ArrayList<Integer> arr, ArrayList<Integer> result, int sum){
        if(index >= arr.size()){
            result.add(sum);
            return;
        }
        sum(index+1, arr, result, sum+arr.get(index));
        sum(index+1, arr, result, sum);
    }
}
