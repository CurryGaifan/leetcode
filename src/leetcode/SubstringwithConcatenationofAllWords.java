package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.rmi.CORBA.Util;

import util.PrintUtil;

/**
 * S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * 
 */
public class SubstringwithConcatenationofAllWords {
	int wholeLength;
	int subLength;

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> list = new ArrayList<Integer>();
		if (L == null || L.length == 0)
			return list;
		subLength = L[0].length();
		wholeLength = subLength * L.length;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String str : L)
			map.put(str, map.get(str) == null ? 1 : map.get(str) + 1);

		// printMap(map);
		int length = L.length * L[0].length();
		for (int i = 0; i + length - 1 < S.length(); i++) {
			if (equal(S, i, map, 0))
				list.add(i);
		}
		return list;
	}

	private boolean equal(String s, int i, Map<String, Integer> map,
			int matchLength) {

		// System.out.println("i: " + i + ",matchLength: " + matchLength);
		// printMap(map);
		if (matchLength == wholeLength) {
			// System.out.println("return true");
			return true;
		}
		String substr = s.substring(i, i + subLength);
		// System.out.println("substr: " + substr);
		if (hasleastOne(map, substr)) {
			map.put(substr, map.get(substr) - 1);
			boolean equal = equal(s, i + subLength, map, matchLength
					+ subLength);
			map.put(substr, map.get(substr) + 1);
			return equal;
		} else {
			// System.out.println("return false");
			return false;
		}

	}

	private boolean hasleastOne(Map<String, Integer> map, String substring) {
		return map.containsKey(substring) && map.get(substring) > 0;
	}

	public static void main(String[] args) {
		// List<Integer> list = new SubstringwithConcatenationofAllWords()
		// .findSubstring(
		// "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel",
		// new String[] { "dhvf", "sind", "ffsl", "yekr", "zwzq",
		// "kpeo", "cila", "tfty", "modg", "ztjg", "ybty",
		// "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw",
		// "bxcb" });
		List<Integer> list = new SubstringwithConcatenationofAllWords()
				.findSubstring("aaa", new String[] { "a", "a" });
		PrintUtil.printList(list);
	}
}
