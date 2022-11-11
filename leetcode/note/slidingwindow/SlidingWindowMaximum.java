package note.slidingwindow;

/*
https://leetcode.com/problems/sliding-window-maximum/description/
 */
public class SlidingWindowMaximum {

    /*
    Time complexity o(n)
    Space complexity o(k)
    Queue to hold maximum and eligible elements to be maximum once the window moves.
    Always add element into queue which are towards right of maximum while creating window,
    lets consider k=3, and the while creating window maximum element is at 2nd index then neglect
    elements towards left since we have already found a maximum element of the window.
    Always remove element from end of the queue which are smaller than the new element.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length+1-k];
        int l=0;
        int r=0;
        for( r=0; r<k; r++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[r]){
                queue.pollLast();
            }
            queue.addLast(r);
        }
        result[l] = nums[queue.getFirst()];

        while(r < nums.length ){
            if( !queue.isEmpty() && queue.peekFirst()==l )
                queue.pollFirst();
            l++;
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[r]){
                queue.pollLast();
            }
            queue.addLast(r);
            result[l] = nums[queue.getFirst()];
            r++;
        }
        return result;
    }
}
