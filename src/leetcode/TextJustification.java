package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * words: ["This", "is", "an", "example", "of", "text", "justification."] L: 16.
 * 
 * [ "This    is    an", "example  of text", "justification.  " ]
 * 
 * @author yanfeixiang
 * 
 */
public class TextJustification {
	static Map<Integer, String> map = new HashMap<Integer, String>();

	public List<String> fullJustify(String[] words, int L) {
		List<String> list = new ArrayList<String>();
		if (words.length == 0)
			return list;

		int i = 0;
		int length = 0;
		int count = 0;
		// String[] str = new String[L];
		List<String> str = new ArrayList<String>();
		int subTolLength = 0;
		while (i < words.length) {
			if (words[i].length() + (count == 0 ? 0 : 1) + length <= L) {

				length += (words[i].length() + (count == 0 ? 0 : 1));
				// str[count] = words[i];
				str.add(words[i]);
				subTolLength += words[i].length();
				count++;
				i++;
			} else {
				String substr = str.get(0);
				if (count == 1) {
					substr += getNSpace(L - substr.length());
				} else {
					int subTotalSpace = L - subTolLength;
					int m = subTotalSpace / (count - 1);
					int n = subTotalSpace % (count - 1);

					for (int j = 1; j < count; j++) {
						if (j < n + 1) {
							substr += getNSpace(m + 1);
						} else {
							substr += getNSpace(m);
						}

						substr += str.get(j);
					}
				}

				list.add(substr);
				length = 0;
				count = 0;
				subTolLength = 0;
				str.clear();
			}

		}

		if (count != 0) {
			String substr = str.get(0);
			for (int k = 1; k < count; k++) {
				substr += " " + str.get(k);
			}
			substr += getNSpace(L - substr.length());
			list.add(substr);
		}

		return list;

	}

	private String getNSpace(int n) {
		String str = map.get(n);
		if (str == null) {
			str = "";
			for (int i = 0; i < n; i++) {

				str += " ";
			}
			map.put(n, str);
		}
		return str;

	}

	public static void main(String[] args) {
		List<String> a = new TextJustification().fullJustify(new String[] {
				"Listen", "to", "many,", "speak", "to", "a", "few." }, 6);

		for (String str : a) {
			System.out.println(str);
		}
	}
}
