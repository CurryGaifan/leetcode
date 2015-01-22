package search;

/**
 * ���ֲ����ֳ��۰���ң�����һ��Ч�ʽϸߵĲ��ҷ����� ���������ֲ���Ҫ�󡿣�1.�������˳��洢�ṹ 2.���밴�ؼ��ִ�С�������С�
 * 
 * @author Administrator
 * 
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] src = new int[] { 1, 3, 5, 7, 8, 9 };
		System.out.println(binarySearch(src, 3));
		System.out.println(binarySearch(src, 3, 0, src.length - 1));
		System.out.println(binarySearchIndex(src, 10, 0, 4));
	}

	/**
	 * * ���ֲ����㷨 * *
	 * 
	 * @param srcArray
	 *            �������� *
	 * @param des
	 *            ����Ԫ�� *
	 * @return des�������±꣬û�ҵ�����-1
	 */
	public static int binarySearch(int[] srcArray, int des) {

		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static int binarySearchIndex(int[] srcArray, int des) {

		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			if (low == high) {
				if (des > srcArray[high])
					return high + 1;
				else
					return low;
			}

			if (high - low == 1) {
				if (des > srcArray[high])
					return high + 1;
				else if (des > srcArray[low])
					return high;
				else
					return low;
			}

			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static int binarySearchIndex(int[] srcArray, int des, int low,
			int high) {

		while (low <= high) {
			if (low == high) {
				if (des > srcArray[high])
					return high + 1;
				else
					return low;
			}

			if (high - low == 1) {
				if (des > srcArray[high])
					return high + 1;
				else if (des > srcArray[low])
					return high;
				else
					return low;
			}

			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * ���ֲ����ض����������������е�λ��(�ݹ�)
	 * 
	 * @paramdataset
	 * @paramdata
	 * @parambeginIndex
	 * @paramendIndex
	 * @returnindex
	 */
	public static int binarySearch(int[] dataset, int data, int beginIndex,
			int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (data < dataset[beginIndex] || data > dataset[endIndex]
				|| beginIndex > endIndex) {
			return -1;
		}
		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		} else if (data > dataset[midIndex]) {
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

}
