package leetcode;

/**
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author yanfeixiang
 * 
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int jumpIndex = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == 0) {
				if (jumpIndex <= i)
					return false;
			} else if (A[i] > 0) {
				jumpIndex = Math.max(jumpIndex, i + A[i]);
			}
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(new JumpGame().canJump(new int[] { 0 }));
	}
}
