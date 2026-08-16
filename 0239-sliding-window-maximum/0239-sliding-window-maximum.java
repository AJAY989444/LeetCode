import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return Sum_of_Window_Size_k(nums, k);
    }

    public static int[] Sum_of_Window_Size_k(int[] arr, int k) {

        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            // window shrink
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // window grow
            dq.addLast(i);

            // answer update
            if (i >= k - 1) {
                ans[index++] = arr[dq.peekFirst()];
            }
        }

        return ans;
    }
}