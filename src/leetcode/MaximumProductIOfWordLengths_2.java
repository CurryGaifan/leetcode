package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yanfeixiang on 2016/8/8.
 */
public class MaximumProductIOfWordLengths_2 {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                bits[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < bits.length; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if (words[i].length() * words[j].length() <= max) {
                    break;
                }
                if ((bits[i] & bits[j]) == 0) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new MaximumProductIOfWordLengths_2().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(new MaximumProductIOfWordLengths_2().maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(new MaximumProductIOfWordLengths_2().maxProduct(new String[]{"edadc", "ebbfe", "aacdde", "dfe", "cb", "fddddff", "fabca", "adccac", "ece", "ccaf", "feba", "bcb", "edadc", "aea", "bacb", "acefa", "fcebffd", "dfeebca", "bedcbaa", "deaccc", "abedc", "dadff", "eef", "ddebbb", "abecab", "cd", "abdeee", "eedce", "deef", "dceaddd", "ced", "fbbf", "ba", "eefeda", "fb", "cddc", "adafbf", "dded", "aadbf", "caefbaf", "ccebf", "dbb", "ee", "dadcecc", "ddbcabb", "afeaa", "ec", "aad", "efde", "cbcda", "cdbdafd", "cddc", "ecaaa", "ae", "cfc", "bccac", "cdcc", "abbbf", "fcdface", "ddbcdc", "bfebb", "daed", "bc", "dc", "ecdfc", "eeb", "bb", "dad", "caecb", "fbe", "bbbc", "cacea", "dbc", "fbe", "bcfffbd", "aeda", "cff", "ddfc", "ea", "bdfd", "ccb", "cb", "ae", "ceabefa", "dcea", "cbaed", "bfedf", "fa", "ccd", "fece", "bceef", "acabca", "dafa", "fdeec", "dac", "cae", "adeeadb", "ecacc", "acfe", "de"}));
    }
}
