package leetcode;

import java.util.*;

/**
 * Created by yanfeixiang on 2016/8/8.
 */
public class MaximumProductIOfWordLengths {
    public int maxProduct(String[] words) {
        List<Pair<Integer, Set<Character>>> list = new ArrayList<>();
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            list.add(new Pair(word.length(), set));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare((Integer) o2.f, (Integer) o1.f);
            }
        });
        int max = 0;
        Pair<Integer, Set<Character>>[] pairs = list.toArray(new Pair[list.size()]);
        for (int i = 0; i < pairs.length; i++) {
            Pair<Integer, Set<Character>> pair = pairs[i];
            for (int j = i + 1; j < pairs.length; j++) {
                Pair<Integer, Set<Character>> sub = pairs[j];
                if (pair.f * sub.f <= max) {
                    break;
                }

                if (!containsSame(pair.t, sub.t)) {
                    max = pair.f * sub.f;
                }
            }
        }
        return max;
    }

    boolean containsSame(Set<Character> set1, Set<Character> set2) {
        for (Character c : set1) {
            if (set2.contains(c))
                return true;
        }

        return false;
    }


    class Pair<F, T> {
        private F f;
        private T t;

        public Pair(F f, T t) {
            this.f = f;
            this.t = t;
        }

    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductIOfWordLengths().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(new MaximumProductIOfWordLengths().maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(new MaximumProductIOfWordLengths().maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
