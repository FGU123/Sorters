package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class ShellSorter {

	/**
	  * 插入排序： <br/>
	 * 3, 1, 38, 4, 21, 8, 76, 7, 2, 5, 6  <br/>
	 * 3, | 1, 38, 4, 21, 8, 76, 7, 2, 5, 6<br/>
	 * 1, 3, | 38, 4, 21, 8, 76, 7, 2, 5, 6<br/> 
	 * 1, 3, 38, | 4, 21, 8, 76, 7, 2, 5, 6<br/> 
	 * 1, 3, 4, 38, | 21, 8, 76, 7, 2, 5, 6<br/> 
	 * ... 								   <br/>
	 * 1, 2, 3, 4, 5, 6, 7, 8, 21, 38, 76  <br/>
	 * 
	 * 	希尔排序：<br/>
	 *  3, 1, 38, 4, 21, 8, 76, 7, 2, 5, 6 <br/>
	 * 
	  *   第一遍，gap=5 <br/>
	 *   
	 * 3 8 6 1 76 38 7 4 2 21 5<br/>
	 * --------------------------------------------- <br/>
	 * 3 8 6 1 76 7 38 2 4 5 21<br/>
	 * ============================================= <br/>
	 * 
	 * 3 1 7 2 5 8 76 38 4 21 6<br/>
	 * 
	 * 	第二遍，gap=2 <br/>
	 * 
	 * 3 7 5 76 4 6 1 2 8 38 21<br/>
	 * --------------------------------------------- <br/>
	 * 3 4 5 6 7 76 1 2 8 21 38<br/>
	 * ============================================= <br/>
	 * 
	 * 	第三遍，gap=1，即把以下序列按插入排序进行即可 <br/>
	 * 	3 1 4 2 5 8 6 21 7 38 76 <br/>
	 * 	如上，插入排序。<br/>
	 * ============================================= <br/>
	 * 
	 * 	gap理解为插入排序的间隔增量，传统的插入排序增量为1，也就是说，希尔排序的最差情况，就是增量为1，也就等同于插入排序
	 * 
	 *  时间复杂度 O(n log n)，空间 O(1)
	 */
	public static void shellSort(int[] numbers) {

		// int gap = 1; //当增量gap不再为动态时，可以置为1，然后把循环去掉，此时就等同于插入排序

		for (int gap = numbers.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < numbers.length; i++) {

				int j = i - gap;

				int target = numbers[i];

				// 把比target大的数都后移，在比较操作最后停下来的位置的数，换成target
				while (j >= 0 && target <= numbers[j]) {
					numbers[j + gap] = numbers[j];
					j = j - gap;
				}
				numbers[j + gap] = target;
			}
		}

	}

	public static void main(String[] args) {
		int[] numbers = new int[] { 3, 1, 38, 4, 21, 8, 76, 7, 2, 5, 6 };
		shellSort(numbers);
		ArrayUtil.print(numbers);
	}
}
