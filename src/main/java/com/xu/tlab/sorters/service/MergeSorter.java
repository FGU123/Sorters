package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class MergeSorter {

	/**
	 * 1、时间复杂度：O(n log n) 2、空间复杂度：O(n) 3、稳定排序 4、非原地排序
	 */
	public static int[] mergeSort(int[] numbers, int left, int right) {

		if (left < right) {

			int mid = (left + right) / 2;
			numbers = mergeSort(numbers, left, mid);
			numbers = mergeSort(numbers, mid + 1, right);

			merge(numbers, left, mid, right);
		}
		
		return numbers;
	}
	
	public static int[] mergeSort0(int[] numbers) {

		int len = numbers.length;
		
		for (int i = 1; i < len; i+=i) {
			int left = 0;
			int mid = left + i - 1;
			int right = mid + i;
			
			while(right < len) {
				merge(numbers, left, mid, right);
				left = right + 1;
				mid = left + i - 1;
				right = mid + i;
			}
			
			if( left < len && mid < len ) {
				merge(numbers, left, mid, len - 1);
			}
		}
		
		return numbers;
	}

	private static void merge(int[] numbers, int left, int mid, int right) {

		int[] tmp = new int[right - left + 1];

		int i = left;

		int j = mid + 1;

		int k = 0;

		while (i <= mid && j <= right) {
			tmp[k++] = numbers[i] < numbers[j] ? numbers[i++] : numbers[j++];
		}

		while (i <= mid) {
			tmp[k++] = numbers[i++];
		}

		while (j <= right) {
			tmp[k++] = numbers[j++];
		}

		for (int c = 0; c < k; c++) {
			numbers[left++] = tmp[c];
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51 };
//		mergeSort(numbers, 0, numbers.length - 1);
		numbers = mergeSort0(numbers);
		ArrayUtil.print(numbers);
	}
}
