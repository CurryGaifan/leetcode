package leetcode;

/**
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int minlength = 0;
        int start = 0;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {

                while (sum >= s) {

                    sum -= nums[start++];

                }
                minlength = minlength == 0 ? (i - start + 2) : (Math.min(minlength, i - start + 2));
                if (minlength == 1)
                    return 1;
            }


        }

        return minlength;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(10000, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
