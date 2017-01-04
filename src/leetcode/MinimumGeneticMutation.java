package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String b : bank)
            set.add(b);

        if (!set.contains(end))
            return -1;

        int min = help(start, end, set, new HashSet<String>());
        if (min == Integer.MAX_VALUE)
            min = -1;
        return min;
    }

    private int help(String start, String end, Set<String> set, Set<String> subSet) {
        if (start.equals(end)) {
            return subSet.size();
        }
        int min = Integer.MAX_VALUE;
        for (String s : set) {
            if (!subSet.contains(s) && canGo(start, s)) {
                subSet.add(s);
                int n = help(s, end, set, subSet);
                min = Math.min(n, min);
                subSet.remove(s);

            }


        }
        return min;
    }

    private boolean canGo(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int difCount = 0;
        for (int i = 0; i < s1.length(); i++) {

            if (c1[i] != c2[i])
                difCount++;
            if (difCount > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(new MinimumGeneticMutation().minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }


}
