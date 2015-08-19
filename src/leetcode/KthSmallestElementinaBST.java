package leetcode;

import leetcode.struct.TreeNode;

/**
 * What if the BST is modified (insert/delete operations)
 * often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Tuple tuple = kthSmallestTuple(root, k);
        return tuple.num;
    }

    public Tuple kthSmallestTuple(TreeNode root, int k) {
        if (root == null)
            return new Tuple();

        Tuple left = kthSmallestTuple(root.left, k);
        if (left.find)
            return left;

        if (k - left.num == 1)
            return new Tuple(true, root.val);

        Tuple right = kthSmallestTuple(root.right, k - left.num - 1);
        if (right.find)
            return right;

        return new Tuple(false, left.num + right.num + 1);


    }

    private class Tuple {
        boolean find;
        int num;

        public Tuple(boolean find, int num) {
            this.find = find;
            this.num = num;
        }

        public Tuple() {
        }
    }
}
