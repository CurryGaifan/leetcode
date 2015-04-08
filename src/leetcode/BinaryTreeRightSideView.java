package leetcode;

import leetcode.struct.TreeNode;
import util.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode[] array = queue.toArray(new TreeNode[queue.size()]);
            queue.clear();
            list.add(array[array.length - 1].val);
            for (TreeNode tn : array) {
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
            }
        }

        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("1,2,3,#,4,#,5");
        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
    }
}
