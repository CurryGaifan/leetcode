package leetcode;

import leetcode.struct.Interval;

import java.util.*;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p/>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p/>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 * <p/>
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 * <p/>
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
public class DataStreamAsDisjointIntervals_2 {
    /**
     * Initialize your data structure here.
     */
    public DataStreamAsDisjointIntervals_2() {

    }

    Map<Integer, Integer> end2start = new HashMap<>();
    Map<Integer, Integer> start2end = new HashMap<>();
    Map<String, Interval> map = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String start1 = o1.substring(0, o1.indexOf("_"));
            String start2 = o2.substring(0, o2.indexOf("_"));

            return Integer.compare(Integer.valueOf(start1), Integer.valueOf(start2));
        }
    });
    Set<Integer> keys = new HashSet<>();

    public void addNum(int val) {
        if (keys.contains(val))
            return;
        keys.add(val);

        if (end2start.containsKey(val - 1)) {
            int start = end2start.get(val - 1);

            if (start2end.containsKey(val + 1)) {
                int end = start2end.get(val + 1);
                end2start.put(end, start);
                start2end.put(start, end);
                map.remove(start + "_" + (val - 1));
                map.remove((val + 1) + "_" + end);
                map.put(start + "_" + end, new Interval(start, end));
            } else {
                end2start.remove(val - 1);
                end2start.put(val, start);
                start2end.put(start, val);
                map.remove(start + "_" + (val - 1));
                map.put(start + "_" + val, new Interval(start, val));
            }


        } else {
            if (start2end.containsKey(val + 1)) {
                int end = start2end.get(val + 1);
                start2end.remove(val + 1);
                start2end.put(val, end);
                end2start.put(end, val);
                map.remove((val + 1) + "_" + (end));
                map.put(val + "_" + (end), new Interval(val, end));
            } else {
                end2start.put(val, val);
                start2end.put(val, val);
                map.put(val + "_" + val, new Interval(val, val));
            }
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals_2 ds = new DataStreamAsDisjointIntervals_2();
        int[] nums = new int[]{1, 3, 7, 2, 6, 2};

        for (int i = 0; i < nums.length; i++) {
            ds.addNum(nums[i]);
            System.out.println(ds.getIntervals());
        }
    }

}
