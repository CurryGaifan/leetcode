package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.PrintUtil;
import leetcode.struct.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<Integer> subList = new ArrayList<Integer>();
		int i = 1;
		int lastLevelNull = 0;
		while (!queue.isEmpty()) {
			subList = new ArrayList<Integer>();

			int nodeCount = i - lastLevelNull * 2;
			lastLevelNull = i - nodeCount;
			for (int j = 0; j < nodeCount; j++) {
				TreeNode node = queue.remove();
				if (node == null) {
					lastLevelNull++;
				} else {
					subList.add(node.val);
					queue.add(node.left);
					queue.add(node.right);
				}
			}
			if (subList.size() != 0)
				list.add(subList);
			i *= 2;
		}

		return list;

	}

	public static void main(String[] args) {

		for (List<Integer> l : new BinaryTreeLevelOrderTraversal()
				.levelOrder(new TreeNode("3,9,20,#,#,15,7"))) {
			PrintUtil.printList(l);

		}
	}
}
