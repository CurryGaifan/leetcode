package leetcode;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanfeixiang on 2016/9/14.
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
//        System.out.println(nums.length);
        BitSet bitSet = new BitSet(nums.length);
        return maxCoins(nums, map, bitSet);
    }

    private int maxCoins(int[] nums, Map<Integer, Integer> map, BitSet bitSet) {
//        System.out.println(map + " " + bitSet);
        int max = 0;
        if (map.containsKey(bitSet.hashCode()))
            return map.get(bitSet.hashCode());
        for (int i = 0; i < nums.length; i++) {
            if (!bitSet.get(i)) {
                bitSet.set(i, true);
                max = Math.max(max, getVal(nums, bitSet, i) + maxCoins(nums, map, bitSet));
//                System.out.println(max);
                bitSet.set(i, false);
            }
        }
        map.put(bitSet.hashCode(), max);
//        System.out.println(map);
        return max;
    }

    private int getVal(int[] nums, BitSet bitSet, int index) {
        int sum = nums[index];
        for (int i = index - 1; i > -1; i--) {
            if (!bitSet.get(i)) {
                sum *= nums[i];
                break;
            }
        }

        for (int i = index + 1; i < nums.length; i++) {
            if (!bitSet.get(i)) {
                sum *= nums[i];
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}));
    }
}
