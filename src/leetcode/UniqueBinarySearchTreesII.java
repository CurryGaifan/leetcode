package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.PrintUtil;
import leetcode.struct.TreeNode;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);

	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}
		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {

			List<TreeNode> lefts = generateTrees(start, i - 1);

			List<TreeNode> rights = generateTrees(i + 1, end);

			for (TreeNode left : lefts) {

				for (TreeNode right : rights) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					list.add(root);

				}

			}
		}

		return list;
	}

	public static void main(String[] args) {

		PrintUtil.printList(new UniqueBinarySearchTreesII().generateTrees(3));
	}

}
