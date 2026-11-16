/**
 * Reverses the second half for comparison, then restores the original links.
 * Time: O(n). Extra space: O(1).
 */
final class ConstantSpacePalindrome {
    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstHalfEnd = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            firstHalfEnd = firstHalfEnd.next;
            fast = fast.next.next;
        }

        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        firstHalfEnd.next = secondHalfStart;

        boolean palindrome = true;
        try {
            ListNode left = head;
            ListNode right = secondHalfStart;

            while (right != null) {
                if (left.val != right.val) {
                    palindrome = false;
                    break;
                }

                left = left.next;
                right = right.next;
            }
        } finally {
            firstHalfEnd.next = reverse(secondHalfStart);
        }

        return palindrome;
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
