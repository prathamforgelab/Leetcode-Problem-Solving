import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Checks a linked-list palindrome by comparing each value with a stack.
 * Time: O(n). Extra space: O(n).
 */
final class StackPalindrome {
    boolean isPalindrome(ListNode head) {
        Deque<Integer> values = new ArrayDeque<>();

        for (ListNode current = head; current != null; current = current.next) {
            values.push(current.val);
        }

        for (ListNode current = head; current != null; current = current.next) {
            if (current.val != values.pop()) {
                return false;
            }
        }

        return true;
    }
}
