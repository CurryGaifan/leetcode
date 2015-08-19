package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - end != 1) {
                if (start == end)
                    list.add("" + start);
                else
                    list.add(start + "->" + end);

                start = end = nums[i];
            } else {
                end++;
            }
        }
        if (start == end)
            list.add("" + start);
        else
            list.add(start + "->" + end);

        return list;

    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2}));
    }
}
