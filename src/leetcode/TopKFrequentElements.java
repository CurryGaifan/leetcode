package leetcode;

import util.PrintUtil;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p/>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p/>
 * Note:
 * You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0 || k <= 0)
            return list;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue(k, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return -Integer.compare(((Pair) o1).second, ((Pair) o2).second);
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        for (Pair pair : queue) {
            list.add(pair.first);
            if (i++ == k - 1)
                break;
        }

        return list;
    }

    private class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        PrintUtil.printList(new TopKFrequentElements().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }

}