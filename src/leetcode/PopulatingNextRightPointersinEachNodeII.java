package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.struct.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		int i = 1;
		int lastLevelNull = 0;
		
		while (!queue.isEmpty()) {
			TreeLinkNode tmp = null;
			int nodeCount = i - lastLevelNull * 2;
			lastLevelNull = i - nodeCount;
			for (int j = 0; j < nodeCount; j++) {
				TreeLinkNode node = queue.remove();

				if (node == null) {
					lastLevelNull++;

				} else {
					if (tmp == null)
						tmp = node;
					else {
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

	public static void main(String[] args) {
		TreeLinkNode tln = new TreeLinkNode("1,2,3");
		new PopulatingNextRightPointersinEachNodeII().connect(tln);
		System.out.println(tln);
	}
}
