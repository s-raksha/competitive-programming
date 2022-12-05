/*
https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {
    /*
    Slow and Fast pointer
    Time complexity O(n)
    Space complexity O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer=head;
        ListNode fastPointer=head;

        while(fastPointer !=null){
            if(fastPointer.next !=null )
                fastPointer=fastPointer.next.next;
            else
                return slowPointer;

            slowPointer=slowPointer.next;
        }
        return slowPointer;
    }
}
