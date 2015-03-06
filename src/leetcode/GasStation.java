package leetcode;

import util.PrintUtil;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] maybeStart = new int[gas.length];

		for (int i = 0; i < gas.length; i++) {
			maybeStart[i] = gas[i] - cost[i];

		}

		boolean con = false;

		for (int i = 0; i < maybeStart.length; i++) {

			if (maybeStart[i] < 0) {
				con = false;
				continue;
			} else {
				if (con)
					continue;
				else
					con = true;
			}
			int gs = 0;
			boolean succ = true;
			for (int j = i; j < gas.length + i; j++) {
				gs += gas[j % gas.length] - cost[j % gas.length];
				if (gs < 0) {
					succ = false;
					break;
				}

			}
			if (succ)
				return i;
		}

		return -1;

	}

	public static void main(String[] args) {
		System.out.println(new GasStation().canCompleteCircuit(new int[] { 5 }, new int[] { 4 }));
	}
}
