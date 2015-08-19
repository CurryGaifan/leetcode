package leetcode;

import leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        search(root, new ArrayList<TreeNode>(), list1, list2, p, q);

//        System.out.println(list1);
//        System.out.println(list2);

        for (int i = 1; i < Math.min(list1.size(), list2.size()) + 1; i++) {
            if (list1.size() < i + 1 || list2.size() < i + 1 || list1.get(i) != list2.get(i))
                return list1.get(i - 1);
        }
        return null;

    }

    private boolean search(TreeNode root, List<TreeNode> cur, List<TreeNode> list1, List<TreeNode> list2,
                           TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        cur.add(root);

        if (root == p) {
            list1.addAll(cur);
        }

        if (root == q) {
            list2.addAll(cur);
        }

        if (list1.size() > 0 && list2.size() > 0)
            return true;

        if (search(root.left, cur, list1, list2, p, q))
            return true;

        if (search(root.right, cur, list1, list2, p, q))
            return true;

        cur.remove(cur.size() - 1);
        return false;


    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        tn1.left = tn2;
        System.out.println(new LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(tn1, tn1, tn2));

    }
}
