package leetcode;

import util.PrintUtil;

import java.util.*;

/**
 *
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List[] array = new List[numCourses];

        for (int[] a : prerequisites) {
            if (array[a[0]] == null) {
                List<Integer> list = new ArrayList<Integer>();
                array[a[0]] = list;
            }
            array[a[0]].add(a[1]);
        }
        return canFinish(array);

    }

    private int[] canFinish(List<Integer>[] array) {
        Set<Integer> passed = new LinkedHashSet<Integer>();

        Set<Integer> cur = new LinkedHashSet<Integer>();

        int[] order = new int[array.length];

        for (int i = 0; i < array.length; i++) {


            if (passed.contains(i))
                continue;
            else {
                cur.clear();
                if (canFinish(array, passed, cur, i))
                    ;
                else
                    return new int[0];

            }


        }


        Iterator<Integer> it
                = passed.iterator();
        int i = 0;
        while (it.hasNext()) {
            order[i++] = it.next();
        }

        return order;
    }

    private boolean canFinish(List<Integer>[] array, Set<Integer> passed, Set<Integer> cur, int index) {
//        System.out.println("passed: " + passed);
//        System.out.println("cur: " + cur);
//        System.out.println("index: " + index);
//        System.out.println("===================");
        cur.add(index);
        if (array[index] != null)
            for (int i = 0; i < array[index].size(); i++) {
//                System.out.println("i: " + i);
                if (passed.contains(array[index].get(i))) {
//                    System.out.println("continue");
                    continue;
                } else if (cur.contains(array[index].get(i))) {
//                    System.out.println("cur contains");
                    return false;
                } else {
                    if (!canFinish(array, passed, cur, array[index].get(i))) {

//                        System.out.println("can't Finish");
                        return false;
                    }


                }


            }
        passed.add(index);
        cur.remove(index);
        return true;

    }

    public static void main(String[] args) {
        PrintUtil.printArray(new CourseScheduleII().findOrder(4, new int[][]{new int[]{1, 0},
                new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}}));
    }
}
