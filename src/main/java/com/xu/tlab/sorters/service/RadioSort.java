package com.xu.tlab.sorters.service;

import java.util.ArrayList;
import java.util.LinkedList;

import com.xu.tlab.sorters.util.ArrayUtil;

public class RadioSort {

	public static void radioSort(int[] numbers) {

		int max = numbers[0];
		// 找出最大值
		for (int n : numbers) {
			max = (n > max ? n : max);
		}

		// 计算最大值是几位数
		int num = sizeOfInt(max);

		// 创建10个桶
		ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>(10);
		// 初始化桶
		for (int i = 0; i < 10; i++) {
			bucketList.add(new LinkedList<Integer>());
		}

		// 进行每一趟的排序，从个位数开始排
		for (int i = 1; i <= num; i++) {
			for (int j = 0; j < numbers.length; j++) {
				// 获取每个数最后第 i 位是数组
				int radio = (numbers[j] / (int) Math.pow(10, i - 1)) % 10;
				// 放进对应的桶里
				bucketList.get(radio).add(numbers[j]);
			}
			// 合并放回原数组
			int k = 0;
			for (int j = 0; j < 10; j++) {
				for (Integer t : bucketList.get(j)) {
					numbers[k++] = t;
				}
				// 取出来合并了之后把桶清光数据
				bucketList.get(j).clear();
			}
		}
	}

	final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

	static int sizeOfInt(int x) {
		for (int i = 0;; i++)
			if (x <= sizeTable[i])
				return i + 1;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, -5, 2, 6, 4, 7, 83, 115, -78, 9, 110, 32, 11, 0, 51 };
		radixSort(numbers);
		ArrayUtil.print(numbers);
	}

	// 支持负数的基数排序
	public static void radixSort(int[] numbers) {
		// 基数，在循环过程中根据数的大小自动增长
		int digitNum = 1;
		// 桶，正数和负数共20个桶
		int[][] bucket = new int[20][numbers.length > 20 ? numbers.length : 20];
		// i 代表当前循环的基数，如 1,10，100....
		for (int i = 1; i <= digitNum; i *= 10) { // 每循环一次 i 需要乘以 10
			// 表示本次循环中基数是否已经扩大
			boolean digitExpanded = false;
			// 本次循环中 20 个桶每个桶中存的数的个数
			int[] amount = new int[20];
			// 放入桶中
			for (int num : numbers) {
				// digit表示 num 要放在 20 格桶中的哪一个
				int digit = (num / i) % 10;
				// 这里是加 10 ，即正数用后 10 个桶，负数用前 10 个桶
				digit += 10;
				// numberAmount[digit] 初始值为 0 ，可以直接使用
				bucket[digit][amount[digit]++] = num;
				// 本次循环中遇到有以下条件时最外层循环条件需要扩大一次，即基数需要乘以10
				// 比如第一次循环时digitNumber = 1，当前 num = 2，则不需扩大
				// 若 num = 10 则需要扩大一次最外层循环
				if (num >= (digitNum * 10) && !digitExpanded) {
					digitNum *= 10;
					digitExpanded = true;
				}
			}
			
			int count = 0;
			// 从 20 个桶中取出数据，完成一次排序
			for (int j = 0; j < 20; j++) {
				for (int k = 0; k < amount[j]; k++) {
					numbers[count++] = bucket[j][k];
				}
			}
		}
	}
}
