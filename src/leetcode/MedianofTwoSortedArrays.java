package leetcode;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int astt = 0;
		int aed = A.length;
		int alst = 0;
		int bstt = 0;
		int bed = B.length;
		int blst = 0;

		while (astt < aed || bstt < bed) {
			if (A[(aed + astt) / 2] > B[(bed + bstt) / 2]) {
				aed = (aed + astt) / 2;
				alst = aed;
				bstt = (bed + bstt) / 2 + 1;
				blst = bstt;
			} else if (A[(aed + astt) / 2] < B[(bed + bstt) / 2]) {
				bed = (bed + bstt) / 2;
				blst = bed;
				astt = (aed + astt) / 2 + 1;
				alst = astt;
			} else {
				alst = astt = aed = (aed + astt) / 2;
				blst = bstt = bed = (bed + bstt) / 2;
			}
		}
		System.out.println(alst);
		System.out.println(blst);

		return 0f;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 3, 5, 7, 9 };
		System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(a, b));
	}
}
