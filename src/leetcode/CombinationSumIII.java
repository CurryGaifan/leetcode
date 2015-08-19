package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * <p/>
 * Input: k = 3, n = 7
 * <p/>
 * Output:
 * <p/>
 * [[1,2,4]]
 * <p/>
 * Example 2:
 * <p/>
 * Input: k = 3, n = 9
 * <p/>
 * Output:
 * <p/>
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        combinationSum3(1, k, n, list, subList);
        return list;

    }

    public void combinationSum3(int start, int k, int n, List<List<Integer>> list, List<Integer> subList) {
        if (subList.size() == k) {
            if (sum(subList) == n) {
                List<Integer> clone = (List<Integer>) ((ArrayList) subList).clone();
                list.add(clone);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            subList.add(i);
            combinationSum3(i + 1, k, n, list, subList);
            subList.remove(subList.size() - 1);
        }

    }

    private int sum(List<Integer> subList) {
        int sum = 0;
        for (int i : subList)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 9));
    }
}
