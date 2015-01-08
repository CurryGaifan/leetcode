package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author yanfeixiang
 * 
 */
public class GenerateParentheses {
	private List<String> list = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		generateParenthesis("", n, n);
		return list;
	}

	public void generateParenthesis(String str, int l_count, int r_count) {

		if (l_count == 0 && r_count == 0) {
			list.add(str);
//			System.out.println(str);
		}

		if (l_count > 0) {
			generateParenthesis(str + "(", l_count - 1, r_count);
		}
		if (r_count > l_count) {
			generateParenthesis(str + ")", l_count, r_count - 1);
		}

	}

	public static void main(String[] args) {
		new GenerateParentheses().generateParenthesis(3);
	}
}
