package leetcode.struct;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(String s) {
        String[] strs = s.split(",");

        if (s.length() == 0 || s.startsWith("#"))
            return;

        this.val = Integer.valueOf(strs[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this);

        for (int i = 1; !queue.isEmpty() && i < strs.length; ) {

            TreeNode tn = queue.remove();
            if (i + 1 == strs.length) {
                tn.left = new TreeNode(Integer.valueOf(strs[i++]));
            } else {

                String str = strs[i++];
                if (!str.equals("#")) {
                    TreeNode left = new TreeNode(Integer.valueOf(str));
                    tn.left = left;
                    queue.add(left);
                }

                str = strs[i++];
                if (!str.equals("#")) {
                    TreeNode right = new TreeNode(Integer.valueOf(str));
                    tn.right = right;
                    queue.add(right);
                }

            }

        }

    }

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this);
        String str = "";
        while (!queue.isEmpty()) {
            TreeNode ln = queue.remove();

            if (ln == null) {
                str += "#";
            } else {
                str += ln.val;
                queue.add(ln.left);
                queue.add(ln.right);

            }
            str += ",";
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new TreeNode("1,2,3,4"));
    }
}