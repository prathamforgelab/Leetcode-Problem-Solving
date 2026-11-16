/**
 * Compares mirrored nodes as recursion unwinds.
 * Time: O(n). Extra space: O(n) for the call stack.
 */
final class RecursivePalindrome {
    boolean isPalindrome(ListNode head) {
        return compareFromEnd(head, new ListNode[] { head });
    }

    private boolean compareFromEnd(ListNode right, ListNode[] left) {
        if (right == null) {
            return true;
        }

        if (!compareFromEnd(right.next, left)) {
            return false;
        }

        if (left[0].val != right.val) {
            return false;
        }

        left[0] = left[0].next;
        return true;
    }
}
