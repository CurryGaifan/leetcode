package leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
		int num = 0;
		for (int a : A)
			num = num ^ a;
		return num;
	}

	public static void main(String[] args) {
		System.out.println(new SingleNumber().singleNumber(new int[] {
				Integer.MIN_VALUE, 1, 1, 2, 5, 7, 7, 5, Integer.MAX_VALUE,
				Integer.MIN_VALUE, Integer.MAX_VALUE }));
	}
}
