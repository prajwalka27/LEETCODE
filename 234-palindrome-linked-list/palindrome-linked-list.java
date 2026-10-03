class Solution {
    public boolean isPalindrome(ListNode head) {
        // Find the middle of the list.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For an odd-length list, skip the middle node.
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse the second half, then compare both halves.
        ListNode secondHalf = reverse(slow);
        ListNode left = head;
        ListNode right = secondHalf;
        boolean palindrome = true;

        while (right != null) {
            if (left.val != right.val) {
                palindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        // Restore the list to its original structure.
        reverse(secondHalf);

        return palindrome;
    }

    private ListNode reverse(ListNode node) {
        ListNode previous = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }

        return previous;
    }
}
