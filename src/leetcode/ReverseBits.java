package leetcode;

/**
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * >>> 逻辑右移位，不保存符号，添0
 * 
 * @author yanfeixiang
 * 
 */
public class ReverseBits {
	public int reverseBits(int n) {

		int m = 0;
		int nn = 1;
		for (int i = 0; i < 32; i++) {
			m = (m << 1) + ((nn & n) >>> i);
			nn <<= 1;

		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverseBits(43261596));
	}
}
