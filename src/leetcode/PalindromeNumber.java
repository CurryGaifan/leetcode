package leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x == 0)
			return true;
		if (x < 0)
			return false;
		if (x % 10 == 0)
			return false;
		int z = x;
		int y = 0;
		while (x > 0) {
			y = y * 10 + x % 10;
			x /= 10;
		}
		return z == y;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(1326446231));
	}
}
