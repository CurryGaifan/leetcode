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

		return canJump(A, 0);

	}

	private boolean canJump(int[] A, int index) {
		if (index == A.length - 1)
			return true;
		if (index > A.length - 1)
			return false;
		for (int i = 1; i <= A[index]; i++) {
			if (canJump(A, index + i))
				return true;
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(new JumpGame().canJump(new int[] {1}));
	}
}
