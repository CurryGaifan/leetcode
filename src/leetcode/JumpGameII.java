package leetcode;

/**
 * [2,3,1,1,4]
 * 
 * @author yanfeixiang
 * 
 */
public class JumpGameII {
	public int jump(int[] A) {
		if (A.length == 0)
			return 0;

		int i = 0;
		boolean[] B = new boolean[A.length];
		B[A.length - 1] = true;
		for (; !B[0]; i++) {
			for (int j = 0; j < B.length; j++) {
				if (B[j])
					continue;
				for (int k = 0; k < A[j] + 1 && !B[j]; k++) {
					if (B[k + j])
						B[j] = true;
				}
			}
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(new JumpGameII().jump(new int[] {}));
	}
}
