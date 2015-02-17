package leetcode;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.struct.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.addFirst(root.left);
		deque.addLast(root.right);

		while (!deque.isEmpty()) {
			TreeNode first = deque.removeFirst();
			TreeNode last = deque.removeLast();
			if (first == null && last == null)
				continue;

			if (first == null || last == null || first.val != last.val)
				return false;
			deque.addFirst(first.left);
			deque.addFirst(first.right);
			deque.addLast(last.right);
			deque.add(last.left);
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new SymmetricTree()
				.isSymmetric(new TreeNode("1,2,2")));
	}

}
