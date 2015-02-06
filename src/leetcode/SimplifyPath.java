package leetcode;

import java.util.Stack;

import util.PrintUtil;

/**
 * path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c" "/../" => "/" ,
 * "/home//foo/" => "/home/foo"
 * 
 * @author yanfeixiang
 * 
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] strs = path.split("/");
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals("..")) {
				if (!stack.empty())
					stack.pop();
			} else if (strs[i].equals(".")) {

			} else if (!strs[i].equals("")) {
				stack.push(strs[i]);
			}
		}
		String result = "";
		for (String str : stack) {
			result += ("/" + str);
		}
		if (result.equals(""))
			result = "/";
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));

//		String str = "/sf//sdfs/sdfsd/.././d/";
//		System.out.println(str.split("/").length);
//		PrintUtil.printArray(str.split("/"));
	}
}
