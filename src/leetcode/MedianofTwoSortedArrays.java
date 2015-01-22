package leetcode;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * Reference http://blog.csdn.net/zxzxy1988/article/details/8587244
 * 如果A[k/2-1]<B[k/2-1]，那么A[0]~A[k/2-1]一定在第k小的数的序列当中
 * 
 * @author yanfeixiang
 * 
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		if ((A.length + B.length) % 2 == 0) {
			return (findKth(A, 0, B, 0, (A.length + B.length) / 2) + findKth(A,
					0, B, 0, (A.length + B.length) / 2 + 1)) / 2;
		} else {
			return findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
		}

	}

	private double findKth(int a[], int m, int b[], int n, int k) {
		if (a.length - 1 - m > b.length - 1 - n)// graceful
			return findKth(b, n, a, m, k);

		if (m == a.length)
			return b[n + k - 1];

		if (k == 1)
			return Math.min(a[m], b[n]);

		// divide k into two parts
		int pa = Math.min(k / 2, a.length - m), pb = k - pa;
		if (a[m + pa - 1] < b[n + pb - 1])
			return findKth(a, m + pa, b, n, k - pa);
		else if (a[m + pa - 1] > b[n + pb - 1])
			return findKth(a, m, b, n + pb, k - pb);
		else
			return a[m + pa - 1];

	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9 };
		int[] b = { 1, 2, 4, 4, 5 };
		System.out.println(new MedianofTwoSortedArrays()
				.findMedianSortedArrays(a, b));
	}
}
