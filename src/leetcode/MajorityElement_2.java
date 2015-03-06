package leetcode;

/**
 * The majority element is the element that appears more than n/2 ⌋ times.
 * 
 * @author yanfeixiang
 * 
 */
public class MajorityElement_2 {
	public int majorityElement(int[] num) {
		int n = num[0];
		int count = 1;
		for (int i = 1; i < num.length; i++) {
			if (num[i] == n) {
				count++;
			} else if (count == 0) {
				n = num[i];
				count++;
			} else {
				count--;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(new MajorityElement_2().majorityElement(new int[] {
				2, 1, 2, 1, 1 }));
	}
}
