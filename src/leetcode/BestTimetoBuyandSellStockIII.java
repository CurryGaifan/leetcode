package leetcode;


public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;

		int[] pointArray = getPointArray(prices);
		int sum = 0;

		for (int i = 0; i < pointArray.length + 1; i = i + 2)
			sum = Math.max(
					sum,
					_maxProfit(pointArray, 0, i - 1)
							+ _maxProfit(pointArray, i, pointArray.length - 1));

		return sum;
	}

	public int _maxProfit(int[] prices, int start, int end) {
		if (end <= start)
			return 0;

		int min = prices[start];
		int maxProfit = 0;
		for (int i = start + 1; i <= end; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - min);
			min = Math.min(min, prices[i]);

		}
		return maxProfit;

	}

	public int[] getPointArray(int[] prices) {
		int[] pointArray = new int[prices.length];
		int length = 0;

		int i = 0;
		while (i < prices.length) {
			int tmpMin = prices[i];
			i++;
			while (i < prices.length && prices[i] <= tmpMin) {
				tmpMin = prices[i];
				i++;

			}
			if (i != prices.length) {
				pointArray[length++] = prices[i - 1];
				int tmpMax = prices[i];
				while (i < prices.length && prices[i] >= tmpMax) {
					tmpMax = prices[i];
					i++;
				}
				pointArray[length++] = prices[i - 1];
			}

		}

		int[] _pointArray = new int[length];
		System.arraycopy(pointArray, 0, _pointArray, 0, length);

		return _pointArray;
	}

	public static void main(String[] args) {
		System.out.println(new BestTimetoBuyandSellStockIII()
				.maxProfit(new int[] { 4, 1, 3, 5, 4, 2, 3, 6, 4, 8, 6 }));
	}
}
