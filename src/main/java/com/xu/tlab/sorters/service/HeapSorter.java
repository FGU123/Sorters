package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class HeapSorter {

	public static void heapSort(int[] data) {

		buildHeap(data);

		// 每次循环都能取到一个极值（最大或最小），该值为根节点
		for (int i = data.length - 1; i > 0; i--) {

			ArrayUtil.swap(data, i, 0);

			// 每次调整都是从根节点开始，i不断减小，保证前一次极值节点不会参与到调整堆，从而不断缩小排序范围，直至所有节点全部排好序
			adjustHeap(data, i, 0);
		}
	}

	private static void buildHeap(int[] data) {
		int startIndex = getParentIndex(data.length - 1);
		// 反复进行调整
		for (int i = startIndex; i >= 0; i--) {
			adjustHeap(data, data.length, i);
		}
	}

	private static void adjustHeap(int[] data, int heapSize, int index) {
		
		// 取得当前节点的左右节点，当前节点为index
		int left = getChildLeftIndex(index);
		
		int right = getChildRightIndex(index);
		
		// 对左右节点和当前节点进行比较
		int target = index;
		if (left < heapSize && compare(data, index, left)) {
			target = left;
		}
		if (right < heapSize && compare(data, target, right)) {
			target = right;
		}
		// 交换位置，再次调整
		if (target != index) {
			
			ArrayUtil.swap(data, target, index);
			
			adjustHeap(data, heapSize, target);
		}
	}

	private static boolean compare(int[] data, int i, int j) {
		return data[i] - data[j] < 0; // 大顶堆是<，小顶堆则是>，升序用大顶堆，降序用小顶堆
	}

	/** 父节点与子节点的关系：父为i，则左子为2i+1，右子为2i+2
	 *  
	 *   1, 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51
	 *         ↑        ↑   ↑
	 *        i=2      2i+1 2i+2
	 *         
	 *          
	 *                   1
	 *           5              2
	 *      6       4        7      83
	 *   15  78   9  10   32  11  0   51
	 * 
	 */
	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}
	
	private static int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	private static int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}

	// 测试
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51 };
		heapSort(numbers);
		ArrayUtil.print(numbers);
	}
}
