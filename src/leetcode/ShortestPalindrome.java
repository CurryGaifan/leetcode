package leetcode;

/**
 * Created by yanfeixiang on 2016/9/14.
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * <p/>
 * For example:
 * <p/>
 * Given "aacecaaa", return "aaacecaaa".
 * <p/>
 * Given "abcd", return "dcbabcd".
 *
 * I do not read the questions carefully. The answer is wrong. ^-^
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        String result = "";
        int i = s.length() / 2;

        if (s.length() % 2 == 0) {
            String lcs = getLCS(new StringBuilder(s.substring(0, i)).reverse().toString(), s.substring(i));
            String tmp = new StringBuffer(lcs).reverse().toString() + lcs;
            if (tmp.length() < (result.length() == 0 ? Integer.MAX_VALUE : result.length()))
                result = tmp;
        }

        for (int j = 0; ; j++) {
            int index = i - j;
            if (index < 0 || (s.length() - index - 1) * 2 + 1 >= (result.length() == 0 ? Integer.MAX_VALUE : result.length()))
                break;
            String tmp = getPedo(s, index);
            if (tmp.length() < (result.length() == 0 ? Integer.MAX_VALUE : result.length()))
                result = tmp;

            if (j == 0)
                continue;
            index = i + j;
            if (index >= s.length() || index * 2 + 1 >= (result.length() == 0 ? Integer.MAX_VALUE : result.length()))
                break;
            tmp = getPedo(s, index);
            if (tmp.length() < (result.length() == 0 ? Integer.MAX_VALUE : result.length()))
                result = tmp;
        }


        return result;
    }

    private String getPedo(String s, int index) {
        char middle = s.charAt(index);
        String lcs = getLCS(new StringBuilder(s.substring(0, index)).reverse().toString(), s.substring(index + 1));
        String tmp = new StringBuffer(lcs).reverse().toString() + middle + lcs;
//        System.out.println(s + " " + index + " " + tmp + " " + new StringBuilder(s.substring(0, index)).reverse().toString() + " " + s.substring(index + 1));
        return tmp;
    }

    private String getLCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int max = 0;
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    max = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, Math.max(dp[i - 1][j], dp[i][j - 1]));
                dp[i][j] = max;
            }
        }
//        PrintUtil.printArray(dp);
        String str = "";
        int i = str1.length();
        int j = str2.length();
        while (i >= 0 && j >= 0) {
//            System.out.println(i + " " + j + " " + str);
            if (i > 0 && j > 0 && dp[i][j] == dp[i - 1][j - 1] + 1 && str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str = str1.charAt(i - 1) + str;
                i--;
                j--;
            } else if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                str = str1.charAt(i - 1) + str;
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1]) {
                str = str2.charAt(j - 1) + str;
                j--;
            } else {
                break;
            }
        }
//        System.out.println(i + " " + j);
        if (i > 1) {
            str = str1.substring(0, i - 1) + str;
        } else if (j > 1) {
            str = str2.substring(0, j - 1) + str;
        }
        return str;
    }

    public static void main(String[] args) {
//        System.out.println(new ShortestPalindrome().getLCS(new StringBuffer("aac").reverse().toString(), "caaa"));
//        System.out.println(new ShortestPalindrome().getLCS(new StringBuffer("aace").reverse().toString(), "aaa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("abcd"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("aa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("ab"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("a"));
        System.out.println(new ShortestPalindrome().shortestPalindrome(""));
    }
}
