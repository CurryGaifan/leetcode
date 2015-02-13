package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * Copy from https://oj.leetcode.com/discuss/8079/my-modified-answer-from-geeksforgeeks-in-java
 * really good Solution.
 * 
 * ps:Sloved this problem with help.
 * 
 */
public class LargestRectangleinHistogram_2 {
	public int largestRectangleArea(int[] height) {
		height = Arrays.copyOf(height, height.length + 1);

		int maxRect = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; ++i) {
			while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
				int popHeight = height[stack.pop()];
				while (!stack.isEmpty() && height[stack.peek()] == popHeight) {
					stack.pop();
				}
				int rect = popHeight
						* (stack.isEmpty() ? i : (i - stack.peek() - 1));
				// System.out.println(rect);
				maxRect = Math.max(maxRect, rect);
			}
			stack.push(i);
		}

		return maxRect;
	}

	public static void main(String[] args) {
		System.out.println(new LargestRectangleinHistogram_2()
				.largestRectangleArea(new int[] { 600, 1000, 1 }));
	}
}
