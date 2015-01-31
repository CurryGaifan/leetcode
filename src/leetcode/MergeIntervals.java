package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;
import leetcode.struct.Interval;

/**
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author gaifan
 * 
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		Interval[] array = intervals.toArray(new Interval[intervals.size()]);
		quick(array);
		List<Interval> list = new ArrayList<Interval>();
		if (array.length == 0)
			return list;
		int end = array[0].end;
		int start = array[0].start;
		for (int i = 1; i < array.length; i++) {
			if (array[i].start <= end) {
				end = Math.max(end, array[i].end);
			} else {
				list.add(new Interval(start, end));
				start = array[i].start;
				end = array[i].end;
			}
		}
		list.add(new Interval(start, end));
		return list;
	}

	public int getMiddle(Interval[] list, int low, int high) {
		Interval tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high].start >= tmp.start) {

				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low].start <= tmp.start) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	public void _quickSort(Interval[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public void quick(Interval[] a2) {
		if (a2.length > 0) { // 查看数组是否为空
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
//		intervals.add(new Interval(-1, 3));
//		intervals.add(new Interval(2, 6));
//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(15, 18));
		List<Interval> list = new MergeIntervals().merge(intervals);
		PrintUtil.printList(list);
	}
}
