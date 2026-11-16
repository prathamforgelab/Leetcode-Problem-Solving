import java.util.ArrayList;
class Solution{
    public boolean isPalindrome(ListNode head){

        // Create an array Liat

        ArrayList<Integer> arr = new ArrayList<>();

        // Store LinkedList Value

        while(head != null){
            arr.add(head.val);
            head = head.next;
        }

        // Create Two Pointers

        int left = 0;
        int right = arr.size() - 1;

        // Compare Values

        while(left < right){
            if(!arr.get(left).equals(arr.get(right))) {
                return false;
            }

            left++;
            right--;
        }
        //all values matched

        return true;
    }
}
