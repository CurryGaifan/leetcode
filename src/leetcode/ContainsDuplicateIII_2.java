package leetcode;

/**
 */
public class ContainsDuplicateIII_2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        k = Math.min(k + 1, nums.length);
        if (k == 0 || t < 0)
            return false;

        int[] array = new int[k];
        System.arraycopy(nums, 0, array, 0, k);

        boolean result = quick(array, t);
        if (result)
            return true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] - t <= 0)
                return true;
        }

        for (int i = 0; i + k < nums.length; i++) {

            int index = binarySearchIndex(array, nums[i]);

            array[index] = nums[i + k];


            while (index > 0 && array[index] < array[index - 1]) {
                swap(array, index, index - 1);
                index--;
            }

            while (index < array.length - 1 && array[index] > array[index + 1]) {
                swap(array, index, index + 1);
                index++;
            }

            if (index > 0 && array[index] - array[index - 1] - t <= 0)
                return true;
            if (index < array.length - 1 && array[index + 1] - array[index] - t <= 0)
                return true;


        }

        return false;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public int getMiddle(int[] list, int low, int high, int t) {
        int tmp = list[low]; // 数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                if (list[high] - tmp - t <= 0)
                    return -1;
                high--;
            }
            list[low] = list[high]; // 比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                if (tmp - list[low] - t <= 0)
                    return -1;
                low++;
            }
            list[high] = list[low]; // 比中轴大的记录移到高端
        }
        list[low] = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }

    public boolean _quickSort(int[] list, int low, int high, int t) {
        if (low < high) {
            int middle = getMiddle(list, low, high, t); // 将list数组进行一分为二
            if (middle == -1)
                return true;
            _quickSort(list, low, middle - 1, t); // 对低字表进行递归排序
            _quickSort(list, middle + 1, high, t); // 对高字表进行递归排序
        }
        return false;
    }

    public boolean quick(int[] a2, int t) {
        if (a2.length > 0) { // 查看数组是否为空
            return _quickSort(a2, 0, a2.length - 1, t);
        }
        return false;
    }


    public static int binarySearchIndex(int[] srcArray, int des) {

        int low = 0;
        int high = srcArray.length - 1;
        while (low <= high) {
            if (low == high) {
                if (des > srcArray[high])
                    return high + 1;
                else
                    return low;
            }

            if (high - low == 1) {
                if (des > srcArray[high])
                    return high + 1;
                else if (des > srcArray[low])
                    return high;
                else
                    return low;
            }

            int middle = (low + high) / 2;
            if (des == srcArray[middle]) {
                return middle;
            } else if (des < srcArray[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


}