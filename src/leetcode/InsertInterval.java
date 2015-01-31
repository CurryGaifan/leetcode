package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;
import leetcode.struct.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		Interval[] array = intervals.toArray(new Interval[intervals.size()]);
		List<Interval> list = new ArrayList<Interval>();

		if (intervals.size() == 0) {
			list.add(newInterval);
			return list;
		}

		int start = newInterval.start;
		int end = newInterval.end;

		boolean find = false;
		boolean find_1 = false;
		for (int i = 0; i < array.length; i++) {
			if ((start <= array[i].start && array[i].start <= end)
					|| (start <= array[i].end && array[i].end <= end)
					|| (array[i].start <= start && start <= array[i].end)
					|| (array[i].start <= end && end <= array[i].end)) {

				// System.out.println("start:" + start + ",end:" + end +
				// ",array["
				// + i + "]:" + array[i]);

				start = Math.min(start, array[i].start);

				end = Math.max(end, array[i].end);

				find = true;
				find_1 = true;
			} else {
				if (find) {
					list.add(new Interval(start, end));
					find = false;
				} else if (end < array[i].start && !find_1) {
					list.add(newInterval);
					find_1 = true;

				}
				list.add(array[i]);

			}

		}
		if (find)
			list.add(new Interval(start, end));
		if (!find_1)
			list.add(newInterval);
		return list;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		// intervals.add(new Interval(1, 2));
		intervals.add(new Interval(2, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 9));
		// intervals.add(new Interval(12, 16));
		List<Interval> list = new InsertInterval().insert(intervals,
				new Interval(0, 1));
		PrintUtil.printList(list);
	}
}
