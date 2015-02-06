package util;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import leetcode.struct.ListNode;

public class PrintUtil {

	public static void printListNode(ListNode l) {
		while (l != null && l.next != null && l.next.next != null) {
			System.out.print(l.val + "->");
			l = l.next;
		}
		if (l != null) {

			if (l.next != null) {
				System.out.print(l.val + "->");
				l = l.next;
			}
			System.out.println(l.val);
		}

	}

	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet())
			System.out.print(entry.getKey() + " " + entry.getValue() + ",");
		System.out.println();
	}

	public static <T> void printList(List<T> list) {
		for (T i : list)
			System.out.print(i + " ");
		System.out.println();
	}

	public static <T> void printVector(Vector<T> v) {
		for (T i : v)
			System.out.print(i + " ");
		System.out.println();
	}

	public static <T> void printArray(T[] array) {
		for (T i : array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static <T> void printArray(T[][] array) {
		for (T[] t : array) {
			for (T i : t)
				System.out.print(i + " ");
			System.out.println();
		}

	}

	public static void printArray(char[] array) {
		for (char i : array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void printArray(int[] array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void printArray(int[][] array) {
		for (int[] t : array) {
			for (int i : t)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public static <T> void printVectorVector(Vector<Vector<T>> v) {
		for (Vector<T> t : v) {
			for (T i : t)
				System.out.print(i + " ");
			System.out.println();
		}

	}

	public static <T> void printListList(List<List<T>> v) {
		for (List<T> t : v) {
			for (T i : t)
				System.out.print(i + " ");
			System.out.println();
		}

	}
}
