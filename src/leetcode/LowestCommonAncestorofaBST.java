package leetcode;

import leetcode.struct.TreeNode;

/**
 *
 */
public class LowestCommonAncestorofaBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root == p)
            return p;
        if (root == q)
            return q;

        if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val))
            return root;

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        return null;
    }
}
