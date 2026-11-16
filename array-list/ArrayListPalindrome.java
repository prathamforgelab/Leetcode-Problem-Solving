import java.util.ArrayList;
import java.util.List;

/**
 * Checks a linked-list palindrome by storing its values in an ArrayList.
 * Time: O(n). Extra space: O(n).
 */
final class ArrayListPalindrome {
    boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();

        for (ListNode current = head; current != null; current = current.next) {
            values.add(current.val);
        }

        for (int left = 0, right = values.size() - 1; left < right; left++, right--) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
        }

        return true;
    }
}
