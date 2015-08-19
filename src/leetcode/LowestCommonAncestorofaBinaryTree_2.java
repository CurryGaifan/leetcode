package leetcode;

import leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class LowestCommonAncestorofaBinaryTree_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return search(root, p, q).ancestor;
    }

    private FindRes search(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null)
            return new FindRes(false, 0, null);
//        System.out.println(root.val + " " + p.val + " " + q.val);

        int find = 0;

        if (root == p && root == q)
            return new FindRes(true, 2, root);

        if (root == p || root == q)
            find = 1;


        FindRes leftRes = search(root.left, p, q);
//        System.out.println(root.val + ", leftRes: " + leftRes + ", find: " + find);
        if (leftRes.find) {
            if (find == 0) {
                if (leftRes.count == 1) {

                    FindRes rightRes = search(root.right, p, q);
//                    System.out.println(root.val + ", rightRes: " + rightRes + ", find: " + find);
                    if (rightRes.find)
                        return new FindRes(true, 2, root);
                    else {
                        return new FindRes(true, 1, null);
                    }

                } else {
                    return leftRes;
                }
            } else {
                return new FindRes(true, 2, root);
            }

        } else {
            FindRes rightRes = search(root.right, p, q);
//            System.out.println(root.val + ", rightRes: " + rightRes + ", find: " + find);
            if (find == 0) {
                if (rightRes.find)
                    if(rightRes.count==1){
                        return new FindRes(true, 1, null);
                    }else {
                        return rightRes;
                    }
                else {
                    return new FindRes(false, 0, null);
                }
            } else {
                if (rightRes.find)
                    return new FindRes(true, 2, root);
                else {
                    return new FindRes(true, 1, null);
                }
            }


        }
    }

    private class FindRes {
        public boolean find;
        public int count;
        public TreeNode ancestor;

        public FindRes(boolean find, int count, TreeNode ancestor) {
            this.find = find;
            this.count = count;
            this.ancestor = ancestor;
        }

        @Override
        public String toString() {
            return "FindRes{" +
                    "find=" + find +
                    ", count=" + count +
                    ", ancestor=" + ancestor +
                    '}';
        }
    }


    //[3,5,1,6,2,0,8,null,null,7,4], node with value 0, node with value 8
    public static void main(String[] args) {
        TreeNode tn0 = new TreeNode(0);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);

        tn3.left = tn5;
        tn3.right = tn1;
        tn5.left = tn6;
        tn5.right = tn2;
        tn1.left = tn0;
        tn1.right = tn8;
        tn2.left = tn7;
        tn2.right = tn4;


        System.out.println(new LowestCommonAncestorofaBinaryTree_2().lowestCommonAncestor(tn3, tn0, tn8).val);

    }
}
