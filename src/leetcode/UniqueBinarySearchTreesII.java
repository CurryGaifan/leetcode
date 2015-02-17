package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.PrintUtil;
import leetcode.struct.TreeNode;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		for (int i = 1; i <= n; i++) {
			TreeNode root = new TreeNode(i);
			generateTrees(stack, root, root, true, 1, i - 1, i - 1);
		}

		// for (TreeNode tn : stack) {
		// generateTrees(list, tn, tn, tn.val + 1, n, n);
		// }

		return list;
	}

	public void generateTrees(List<TreeNode> list, TreeNode root,
			TreeNode child, int start, int end, int n) {
		if (start > end) {
			child = null;
			System.out.println("start>>>>end: " + root);
			return;
		}

		if (start == n) {
			child.val = start;
			list.add(copy(root));
			System.out.println("2: " + root);
			return;
		}

		for (int i = start; i <= end; i++) {
			child.val = i;
			TreeNode left = new TreeNode(0);
			child.left = left;
			generateTrees(list, root, left, start, i - 1, n);

			for (int j = i + 1; j <= end; j++) {

				TreeNode right = new TreeNode(0);
				child.right = right;
				generateTrees(list, root, right, i + 1, end, n);
			}

		}
	}

	public void generateTrees(Stack<TreeNode> stack, TreeNode root,
			TreeNode child, boolean isLeft, int start, int end, int n) {
		System.out.println(root);
		System.out.println("root:" + root.val + ",isLeft:" + isLeft + ",child:"
				+ child.val + ",start: " + start + ",end:" + end + ",n:" + n);
		if (start > end) {
			System.out.println("start>>>>end: " + root);
			return  ;
		}

		if (start == n) {
			TreeNode node = new TreeNode(start);
			if (isLeft)
				child.left = node;
			else
				child.right = node;
			stack.add(copy(root));
			System.out.println("1: " + root);
			return ;
		}

		for (int i = start; i <= end; i++) {
			TreeNode node = new TreeNode(i);
			if (isLeft)
				child.left = node;
			else
				child.right = node;


			generateTrees(stack, root, node, true, start, i - 1, n-1);

			for (int j = i + 1; j <= end; j++) {

				generateTrees(stack, root, node, false, i + 1, end, );
			}

		}

	}

	private TreeNode copy(TreeNode root) {
		TreeNode _root = null;
		copy(root, _root);
		return _root;
	}

	private void copy(TreeNode root, TreeNode _root) {
		if (root == null) {
			_root = null;
			return;
		}
		_root = new TreeNode(root.val);
		_root.left = root.left;
		_root.right = root.right;
		copy(root.left, _root.left);
		copy(root.right, _root.right);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode tn1 = new TreeNode(2);
		root.left = tn1;

		TreeNode tn2 = new TreeNode(3);
		tn1.left = tn2;

		System.out.println(root);

		PrintUtil.printList(new UniqueBinarySearchTreesII().generateTrees(3));
	}

}
