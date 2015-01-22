package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * [2,3,1,1,4]
 * 
 * @author yanfeixiang
 * 
 */
public class JumpGameII_2 {
	public int jump(int[] A) {
		if (A.length <= 1)
			return 0;

		// int[] B = new int[A.length];
		Queue<Node> queue = new LinkedList<Node>();
		Set<Integer> set = new HashSet<Integer>();
		queue.add(new Node(0, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = A[node.index]; i > 0; i--) {
				if (node.index + i == A.length - 1) {
					return node.step + 1;
				}

				if (!set.contains(node.index + i)) {
					set.add(node.index + i);
					queue.add(new Node(node.index + i, node.step + 1));

				}
			}
		}

		return -1;

	}

	private class Node {
		public Node(int index, int step) {
			this.index = index;
			this.step = step;
		}

		int index;
		int step;
	}

	public static void main(String[] args) {
		System.out.println(new JumpGameII_2()
				.jump(new int[] { 1, 2, 3, 4, 5, 6 }));
	}
}
