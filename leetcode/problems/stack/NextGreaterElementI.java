/*
https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {
    /*
    Time complexity 0(n)
    Space complexity 0(n)
    stack to find next grater element hashmap is to search element
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[nums1.length];

        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && (nums2[stack.peek()] < nums2[i])){
                hashMap.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            hashMap.put(nums2[stack.pop()],-1);
        }

        for(int i=0; i<nums1.length; i++){
            result[i] = hashMap.get(nums1[i]);
        }

        return result;

    }
}
