package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class CountingSorter {

	public static void countingSort(int[] numbers) {
		
		int max = 0;
		
		int min = 0;
		
		for (int n : numbers) {
			max = ( n > max ? n : max );
			min = ( n < min ? n : min );
		}
		
		int[] countArr = new int[max - min + 1];
		
		for (int i = 0; i < numbers.length; i++) {
			countArr[numbers[i] - min]++;
		}
		
		int index = 0;
		for (int i = 0; i < countArr.length; i++) {
			while ( (countArr[i]--) > 0 ) {
				numbers[index++] = i + min;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = { 1, -5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51 };
		countingSort(numbers);
		ArrayUtil.print(numbers);
	}
}
