package leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0)
			return 0;

		int[] count = new int[2];

		count[0] = 1;
		count[1] = 2;

		int i = 3;
		while (i <= n) {
			count[(i + 1) % 2] = count[0] + count[1];
			i++;
		}
		return count[(n + 1) % 2];
	}

	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(6));
	}
}
