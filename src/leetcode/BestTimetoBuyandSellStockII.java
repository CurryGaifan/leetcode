package leetcode;

public class BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int sum = 0;
		int i = 0;

		while (i < prices.length) {
			int tmpMin = prices[i];
			i++;
			while (i < prices.length && prices[i] <= tmpMin) {
				tmpMin = prices[i];
				i++;

			}
			if (i == prices.length)
				return sum;
			int tmpMax = prices[i];
			while (i < prices.length && prices[i] >= tmpMax) {
				tmpMax = prices[i];
				i++;
			}
			sum += (tmpMax - tmpMin);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new BestTimetoBuyandSellStockII()
				.maxProfit(new int[] { 4, 1, 3, 5, 4, 2, 3, 6, 4, 8, 6 }));
	}
}
