package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]
 * 
 * @author yanfeixiang
 * 
 */

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {

		List<String> list = new ArrayList<String>();
		if (s.length() > 12)
			return list;
		restoreIpAddresses(list, s, 0, "");
		return list;
	}

	private void restoreIpAddresses(List<String> list, String s, int index,
			String str) {
		String[] s_a = str.split("\\.");
		if (index == s.length()) {
			if (s_a.length == 4) {
				for (int i = 0; i < 4; i++)
					if (s_a[i].equals("")
							|| (s_a[i].startsWith("0") && s_a[i].length() > 1)
							|| !(0 <= Integer.valueOf(s_a[i]) && 255 >= Integer
									.valueOf(s_a[i])))
						return;

				list.add(str);

			}
			return;
		}

		if (s_a.length != 0
				&& (s_a[s_a.length - 1].length() > 3 || (s_a[s_a.length - 1]
						.length() > 0 && Integer.valueOf(s_a[s_a.length - 1]) > 255)))
			return;
		restoreIpAddresses(list, s, index + 1,
				str + s.substring(index, index + 1));
		restoreIpAddresses(list, s, index + 1,
				str + "." + s.substring(index, index + 1));

	}

	public static void main(String[] args) {
		PrintUtil
				.printList(new RestoreIPAddresses().restoreIpAddresses("0000"));
	}

}
