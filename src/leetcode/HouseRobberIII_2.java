package leetcode;

import leetcode.struct.TreeNode;

/**
 * Created by gaifan on 2016/8/18.
 */
public class HouseRobberIII_2 {

    public int rob(TreeNode root) {
        int[] maxs = dpRob(root);
        return Math.max(maxs[0], maxs[1]);
    }

    public int[] dpRob(TreeNode root) {

        if (root == null)
            return new int[]{0, 0};

        int[] leftDpRob = dpRob(root.left);
        int[] rightDpRob = dpRob(root.right);
        int leftValue = root.left == null ? 0 : root.left.val;
        int rightValue = root.right == null ? 0 : root.right.val;
        return new int[]{Math.max(leftDpRob[0], leftDpRob[1]) + Math.max(rightDpRob[0], rightDpRob[1]),
                Math.max(leftDpRob[0] + rightDpRob[0] + root.val,
                        leftDpRob[1] + rightDpRob[1] + root.val - leftValue - rightValue
                )};
    }


    public static void main(String[] args) {
        TreeNode tn = new TreeNode("3,2,3,#,3,#,1");
        System.out.println(new HouseRobberIII_2().rob(tn));
        TreeNode tn1 = new TreeNode("3,4,5,1,3,#,1");
        System.out.println(new HouseRobberIII_2().rob(tn1));
        TreeNode tn2 = new TreeNode("4,1,#,2,#,3");
        System.out.println(new HouseRobberIII_2().rob(tn2));
        TreeNode tn3 = new TreeNode("2,1,3,#,4");
        System.out.println(new HouseRobberIII_2().rob(tn3));
    }

}
