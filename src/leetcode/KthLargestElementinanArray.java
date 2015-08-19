package leetcode;

/**
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p/>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        return quick(nums, k);
    }


    public int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] <= tmp) {

                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] >= tmp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        return low;
    }

    public int _quickSort(int[] list, int low, int high, int k) {

//        PrintUtil.printArray(list);
//        System.out.println(low + "  " + high + " " + k);


        if (low < high) {
            int middle = getMiddle(list, low, high);
//            System.out.println(middle);

            if (middle == k - 1) {
                return list[middle];
            } else if (middle < k - 1)
                return _quickSort(list, middle + 1, high, k);
            else
                return _quickSort(list, low, middle - 1, k);

        } else if (low == high && low + 1 == k)
            return list[low];
        else if (low == high && high + 1 == k)
            return list[high];
        return 0;
    }

    public int quick(int[] a2, int k) {
        if (a2.length < k)
            return 0;

        if (a2.length > 0) {
            return _quickSort(a2, 0, a2.length - 1, k);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementinanArray().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
    }
}
