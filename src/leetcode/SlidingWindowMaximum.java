package leetcode;

import util.PrintUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * monotonic queue 单调队列
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];


        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k)
                result[i - k] = nums[deque.peekFirst()];
            if (!deque.isEmpty() && i - deque.peekFirst() == k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty()) {

                if (nums[deque.peekLast()] <= nums[i]) {
                    deque.removeLast();
                } else
                    break;
            }
            deque.addLast(i);
        }
        result[result.length - 1] = nums[deque.peekFirst()];

        return result;
    }


    public static void main(String[] args) {
        PrintUtil.printArray(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3));
    }
}
