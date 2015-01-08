package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * '(', ')', '{', '}', '[' and ']'
 * 
 * @author yanfeixiang
 * 
 */
public class ValidParentheses {
	private static Map<Character, Character> map = new HashMap<Character, Character>();

	static {
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
	}

	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (list.size() == 0)
				list.add(chars[i]);
			else if (map.containsKey(chars[i])
					&& map.get(chars[i]) == list.get(list.size() - 1)) {
				list.remove(list.size() - 1);
			} else {
				list.add(chars[i]);
			}
		}

		return list.size() == 0;
	}

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()[}{}"));
	}
}
