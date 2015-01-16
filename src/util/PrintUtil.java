package util;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PrintUtil {
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
}
