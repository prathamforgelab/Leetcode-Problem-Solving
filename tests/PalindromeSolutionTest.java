import java.util.Arrays;

/**
 * Small dependency-free checks for all LeetCode 234 approaches.
 */
public final class PalindromeSolutionTest {
    private interface PalindromeCheck {
        boolean isPalindrome(ListNode head);
    }

    public static void main(String[] args) {
        checkCases("ArrayList", new ArrayListPalindrome()::isPalindrome);
        checkCases("Stack", new StackPalindrome()::isPalindrome);
        checkCases("Recursion", new RecursivePalindrome()::isPalindrome);

        ConstantSpacePalindrome constantSpace = new ConstantSpacePalindrome();
        checkCases("Constant space", constantSpace::isPalindrome);
        checkRestoration(constantSpace, new int[] { 1, 2, 3, 2, 1 }, true, "odd palindrome");
        checkRestoration(constantSpace, new int[] { 1, 2, 3, 4 }, false, "mismatch");

        System.out.println("All palindrome solution checks passed.");
    }

    private static void checkCases(String approach, PalindromeCheck check) {
        checkCase(approach, check, "empty list", new int[] {}, true);
        checkCase(approach, check, "single node", new int[] { 7 }, true);
        checkCase(approach, check, "two-node palindrome", new int[] { 1, 1 }, true);
        checkCase(approach, check, "two-node mismatch", new int[] { 1, 2 }, false);
        checkCase(approach, check, "odd palindrome", new int[] { 1, 2, 3, 2, 1 }, true);
        checkCase(approach, check, "even palindrome", new int[] { 1, 2, 2, 1 }, true);
        checkCase(approach, check, "middle mismatch", new int[] { 1, 2, 3, 4, 1 }, false);
        checkCase(approach, check, "negative values", new int[] { -1, 4, 4, -1 }, true);
    }

    private static void checkCase(
            String approach,
            PalindromeCheck check,
            String caseName,
            int[] values,
            boolean expected) {
        boolean actual = check.isPalindrome(chain(values));
        if (actual != expected) {
            throw new AssertionError(
                    approach + " failed " + caseName + " for " + Arrays.toString(values));
        }
    }

    private static void checkRestoration(
            ConstantSpacePalindrome solution,
            int[] values,
            boolean expected,
            String caseName) {
        ListNode[] nodes = nodes(values);
        boolean actual = solution.isPalindrome(nodes.length == 0 ? null : nodes[0]);

        if (actual != expected) {
            throw new AssertionError("Constant-space solution returned the wrong result for " + caseName);
        }

        for (int index = 0; index < nodes.length; index++) {
            ListNode expectedNext = index + 1 < nodes.length ? nodes[index + 1] : null;
            if (nodes[index].next != expectedNext) {
                throw new AssertionError("Constant-space solution did not restore links for " + caseName);
            }
        }
    }

    private static ListNode chain(int... values) {
        ListNode head = null;
        for (int index = values.length - 1; index >= 0; index--) {
            head = new ListNode(values[index], head);
        }
        return head;
    }

    private static ListNode[] nodes(int... values) {
        ListNode[] result = new ListNode[values.length];
        for (int index = 0; index < values.length; index++) {
            result[index] = new ListNode(values[index]);
            if (index > 0) {
                result[index - 1].next = result[index];
            }
        }
        return result;
    }
}
