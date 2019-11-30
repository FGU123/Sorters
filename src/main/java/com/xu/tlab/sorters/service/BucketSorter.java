package com.xu.tlab.sorters.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.xu.tlab.sorters.util.ArrayUtil;

public class BucketSorter {

	public static void bucketSort(int[] numbers) {

		int max = 0;

		int min = 0;

		for (int n : numbers) {
			max = Math.max(max, n);
			min = Math.min(min, n);
		}

		int d = max - min;

		int bucketNum = d / 5 + 1;

		List<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>(bucketNum);

		// 初始化桶
		for (int i = 0; i < bucketNum; i++) {
			bucketList.add(new LinkedList<Integer>());
		}

		// 元素入桶
		for (int i = 0; i < numbers.length; i++) {
			bucketList.get((numbers[i] - min) / d).add(numbers[i] - min);
		}

		// 桶内元素排序
		for (LinkedList<Integer> ll : bucketList) {
			sort(ll);
		}

		int count = 0;
		for (int i = 0; i < bucketNum; i++) {
			for (Integer n : bucketList.get(i)) {
				numbers[count++] = n + min;
			}
		}
	}

	private static void sort(LinkedList<Integer> ll) {
		int[] arr = new int[ll.size()];

		for (int i = 0; i < ll.size(); i++) {
			arr[i] = ll.get(i);
		}

		QuickSorter.quickSort(arr, 0, arr.length - 1);

		ll.clear();

		for (int i : arr) {
			ll.add(i);
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 1, -5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51 };
		bucketSort(numbers);
		ArrayUtil.print(numbers);
	}
}
