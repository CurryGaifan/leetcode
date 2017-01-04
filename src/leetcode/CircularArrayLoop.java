package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1)
            return false;
        Set<Integer> set = new HashSet();
        Set<Integer> subSet = new HashSet();

        for (int i = 0; i < nums.length && set.size() != nums.length; i++) {
            if (set.contains(i))
                continue;


            boolean f = nums[i] > 0;
            int nextIndex = i;

//            System.out.println("nextIndex1:" + nextIndex);
//            System.out.println("set:" + set + ",subset: " + subSet);
            int lastIndex = -1;
            while (!set.contains(nextIndex) && !subSet.contains(nextIndex)) {
                if (f ^ (nums[nextIndex] > 0)) {
                    set.addAll(subSet);
                    subSet.clear();
                    break;
                }
                subSet.add(nextIndex);
                lastIndex = nextIndex;
                nextIndex += nums[nextIndex];
                nextIndex %= nums.length;
                if (nextIndex < 0)
                    nextIndex += nums.length;

//                System.out.println("nextIndex2:" + nextIndex);
            }
            if (set.contains(nextIndex)) {
                set.addAll(subSet);
                subSet.clear();
            } else if (subSet.contains(nextIndex)) {

                if (nextIndex != lastIndex) {
//                    System.out.println(subSet);

                    return true;
                } else {
                    set.addAll(subSet);
                    subSet.clear();
                }

            }

        }

        return false;
    }


    public static void main(String[] args) {
//        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
//        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-1, 2}));
//        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
//        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{3, 1, 2}));
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-1, -2, -3, -4, -5}));
    }
}
