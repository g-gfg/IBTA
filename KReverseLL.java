public class KReverseLL {
    
    public ListNode reverseK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        int count = 0;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next != null)
            head.next = reverseK(next, k);
        return prev;
    }
    
    public ListNode reverseList(ListNode A, int B) {
        if(B <= 1)
            return A;
        
        return reverseK(A, B);
    }
}