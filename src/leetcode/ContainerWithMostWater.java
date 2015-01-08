package leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int capability = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {

			int water = Math.min(height[left], height[right]) * (right - left);
			capability = Math.max(capability, water);

			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return capability;
	}

	public static void main(String[] args) {

		int[] array = new int[15000];
		for (int i = 0; i < array.length; i++)
			array[i] = 15000 - i + 1;

		System.out.println(new ContainerWithMostWater().maxArea(array));
	}
}
