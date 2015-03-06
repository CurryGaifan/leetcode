package leetcode;


/**
 * •Each child must have at least one candy.
 * 
 * •Children with a higher rating get more candies than their neighbors.
 * 
 * @author yanfeixiang
 * 
 */
public class Candy {
	public int candy(int[] ratings) {
		int[] count = new int[ratings.length];

		for (int i = 0; i < ratings.length; i++) {

			if (i > 0
					&& (i == ratings.length - 1 || ratings[i] <= ratings[i + 1])
					&& ratings[i] < ratings[i - 1]) {
				riseLeft(ratings, count, i - 1);
			}

			if (i < ratings.length - 1
					&& (i == 0 || ratings[i] <= ratings[i - 1])
					&& ratings[i] < ratings[i + 1]) {
				riseRight(ratings, count, i + 1);
			}
//			PrintUtil.printArray(count);
		}
		int sum = count.length;
		for (int i : count) {
			sum += i;
		}
		return sum;

	}

	private void riseLeft(int[] ratings, int[] count, int i) {
		for (; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				count[i] = Math.max(count[i], count[i + 1] + 1);
			} else
				break;
		}
	}

	private void riseRight(int[] ratings, int[] count, int i) {
		for (; i < count.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				count[i] = Math.max(count[i], count[i - 1] + 1);
			} else
				break;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Candy().candy(new int[] { 1, 2, 3, 4, 5, 5, 6,
				3, 2 }));
		System.out.println(new Candy().candy(new int[] { 1, 0, 2 }));
	}
}
