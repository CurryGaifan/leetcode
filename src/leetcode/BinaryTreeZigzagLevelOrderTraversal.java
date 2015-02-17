package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.struct.TreeNode;
import util.PrintUtil;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<Integer> subList = new ArrayList<Integer>();
		int i = 1;
		int lastLevelNull = 0;
		while (!queue.isEmpty()) {
			subList = new ArrayList<Integer>();

			int nodeCount = (int) Math.pow(2, i - 1) - lastLevelNull * 2;
			lastLevelNull = (int) Math.pow(2, i - 1) - nodeCount;
			for (int j = 0; j < nodeCount; j++) {

				TreeNode node = i % 2 == 1 ? queue.removeFirst() : queue
						.removeLast();
				if (node == null) {
					lastLevelNull++;
				} else {
					subList.add(node.val);
					if (i % 2 == 1) {
						queue.addLast(node.left);
						queue.addLast(node.right);

					} else {
						queue.addFirst(node.right);
						queue.addFirst(node.left);

					}

				}
			}

			if (subList.size() != 0)
				list.add(subList);
			i++;
		}

		return list;

	}

	public static void main(String[] args) {

		for (List<Integer> l : new BinaryTreeZigzagLevelOrderTraversal()
				.zigzagLevelOrder(new TreeNode("1,2,3,4,5,6,7,8,9,10,12,13,14,15,16"))) {
			PrintUtil.printList(l);

		}
	}
}
