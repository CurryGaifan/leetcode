package leetcode;

/**
 * the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3
 * 
 * @author yanfeixiang
 * 
 */
public class Numberof1Bits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		int m = 1;
		for (int i = 0; i < 32; i++) {
			if (m == (n & m)) {
				count++;
			}
			m <<= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Numberof1Bits().hammingWeight(8));
	}
}
