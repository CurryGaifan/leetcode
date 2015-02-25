package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.struct.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> subList = new ArrayList<Integer>();
		_pathSum(list, subList, root, sum);
		return list;
	}

	public void _pathSum(List<List<Integer>> list, List<Integer> subList,
			TreeNode root, int sum) {
		if (root == null)
			return;
		
		subList.add(root.val);
		if (root.left == null && root.right == null && sum == root.val) {
			list.add((ArrayList) ((ArrayList) subList).clone());
			subList.remove(subList.size() - 1);
			return;
		}

		_pathSum(list, subList, root.left, sum - root.val);
		_pathSum(list, subList, root.right, sum - root.val);
		subList.remove(subList.size() - 1);
	}
}
