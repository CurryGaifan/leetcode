package leetcode;

import java.util.*;

/**
 * For example,
 * Given "egg", "add", return true.
 * <p/>
 * Given "foo", "bar", return false.
 * <p/>
 * Given "paper", "title", return true.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char s_c = s.charAt(i);
            char t_c = t.charAt(i);
            if (map.containsKey(s_c)) {
                if (map.get(s_c) != t_c)
                    return false;
            } else if (!set.contains((t_c))) {
                map.put(s_c, t_c);
                set.add(t_c);
            } else {

                return false;
            }
        }
        return true;

    }
}
