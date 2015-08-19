package leetcode;

import leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> stackPath = new Stack<>();
        if (root == null)
            return list;
        stack.add(root);
        stackPath.add("" + root.val);
//        String path = "";
//        path = addNode(path, root.val);
//        System.out.println("path: " + path);
        while (!stack.empty()) {
//            System.out.println(stack);
//            System.out.println(path);
            TreeNode cur = stack.pop();
            String path = stackPath.pop();
            if (cur == null)
                continue;
            if (cur.left == null && cur.right == null) {
                list.add(path);
            }
            if (cur.right != null) {
                stack.add(cur.right);
                stackPath.add(addNode(path, cur.right.val));
            }
            if (cur.left != null) {
                stack.add(cur.left);
                stackPath.add(addNode(path, cur.left.val));
            }

        }
        return list;

    }

    private String addNode(String path, int node) {

        return path.length() == 0 ? "" + node : path + "->" + node;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreePaths().binaryTreePaths(new TreeNode("1,2,3,#,5")));
    }
}
