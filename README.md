# LeetCode Problem Solving

A collection of LeetCode solutions, organized by technique. The examples are self-contained Java code so they can be compiled and checked locally.

## LeetCode 234: Palindrome Linked List

[Problem statement](https://leetcode.com/problems/palindrome-linked-list/)

| Solution | Technique | Time | Extra space |
| --- | --- | --- | --- |
| [ArrayListPalindrome](array-list/ArrayListPalindrome.java) | Copy values to an ArrayList and compare from both ends | O(n) | O(n) |
| [StackPalindrome](stack/StackPalindrome.java) | Push values, then compare while popping | O(n) | O(n) |
| [RecursivePalindrome](recursion/RecursivePalindrome.java) | Compare mirrored nodes while recursion unwinds | O(n) | O(n) call stack |
| [ConstantSpacePalindrome](two-pointers/ConstantSpacePalindrome.java) | Reverse the second half, compare, then restore the list | O(n) | O(1) |

Each solution uses the small local `ListNode` type in [ListNode.java](ListNode.java). To submit a solution on LeetCode, copy its method into the platform's `Solution` class and use LeetCode's provided `ListNode` definition.

## Run the checks

Requires JDK 8 or newer. From the repository root:

```sh
javac -d build ListNode.java array-list/ArrayListPalindrome.java stack/StackPalindrome.java recursion/RecursivePalindrome.java two-pointers/ConstantSpacePalindrome.java tests/PalindromeSolutionTest.java
java -cp build PalindromeSolutionTest
```

The checks cover empty and single-node lists, odd and even palindromes, mismatches, and negative values. They also confirm the constant-space solution restores the original list links.
