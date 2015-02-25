package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.struct.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		int i = 1;
		int lastLevelNull = 0;
		TreeLinkNode tmp = null;
		while (!queue.isEmpty()) {

			int nodeCount = i - lastLevelNull * 2;
			lastLevelNull = i - nodeCount;

			for (int j = 0; j < nodeCount; j++) {

				TreeLinkNode node = queue.remove();

				if (j == 0)
					tmp = node;

				if (node == null) {
					lastLevelNull++;
				} else {
					if (j != 0) {
						tmp.next = node;
						tmp = tmp.next;
					}
					queue.add(node.left);
					queue.add(node.right);
				}
			}

			i *= 2;
		}

	}
}
