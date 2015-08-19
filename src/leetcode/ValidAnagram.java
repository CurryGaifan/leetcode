package leetcode;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p/>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] s_count = new int[26];
        int[] t_count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            s_count[s.charAt(i) - 'a']++;
            t_count[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s_count.length; i++)
            if (s_count[i] != t_count[i])
                return false;
        
        return true;

    }
}
