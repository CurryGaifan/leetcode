package leetcode;

import leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaifan on 2016/8/18.
 */
public class HouseRobberIII {
    private static final Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (map.containsKey(root))
            return map.get(root);

        if (root == null)
            return 0;

        int max = root.val;
        if (root.left != null)
            max += (rob(root.left.left) + rob(root.left.right));
        if (root.right != null)
            max += (rob(root.right.left) + rob(root.right.right));

        int left = rob(root.left);
        int right = rob(root.right);
        max = Math.max(max, left + right);
        map.put(root, max);
        return max;
    }
    

    public static void main(String[] args) {
        TreeNode tn = new TreeNode("3,2,3,#,3,#,1");
        System.out.println(new HouseRobberIII().rob(tn));
        TreeNode tn1 = new TreeNode("3,4,5,1,3,#,1");
        System.out.println(new HouseRobberIII().rob(tn1));
    }

}
