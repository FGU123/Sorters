package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class QuickSorter {

	/**
	 * 1, 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51    <br/>
	 *                                                       <br/>
	 * 1, | 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51  <br/>
	 * 		↑                                            ↑   <br/>
	 *		i                                            j   <br/>
	 *                                                       <br/>
	 * 1, | 0, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 5, 51  <br/>
	 * 		↑										  ↑      <br/>
	 *      i										  j      <br/>
	 *                                                       <br/>
	 * 1, | 0, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 5, 51  <br/>
	 * 		   ↑								  ↑		     <br/>
	 *         i	                  ← ← ... ← ← j          <br/>
	 *      								                 <br/>
	 * 1, | 0, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 5, 51  <br/>
	 * 		   ↑										     <br/>
	 *         i,j重合（下一步，2与pivot交换）               <br/>
	 *                                                       <br/>
	 * 第二趟（递归调用），2为pivot                          <br/>
	 * 2, | 0, 1, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 5, 51  <br/>
	 * 			  ↑                                      ↑	 <br/>
	 * 			  i → → ... → →			     ← ← ... ← ← j   <br/>
	 *                                                       <br/>
	 * ...                                                   <br/>
	 *                                                       <br/>
	 * 重复第一趟的做法，直至递归调用完毕，意味着全部有序。  <br/>
	 * 
	 */
	private static int partition(int[] numbers, int left, int right) {

		int pivot = numbers[left]; // 可以改成random选出的中轴数
		
		int i = left + 1;
		
		int j = right;

		// 左右两个指针，i从pivot后面一位数字开始，j从数组最右边数字开始
		// 两边向中间夹逼，j指针走过的数字都要比pivot大，i指针走过的数字都要比pivot小，遇到不满足则i，j下标的两个数交换
		// 如是者，直至j指针比i指针走得更前或者i与j相遇重合，即j<=i，停止循环
		for (;;) {

			while (i <= j && numbers[i] <= pivot) {
				i++;
			}
			
			while (i <= j && numbers[j] >= pivot) {
				j--;
			}
			
			if ( j <= i ) {
				break;
			}

			ArrayUtil.swap(numbers, i, j);
		}

		// 交换pivot与j指针指向的数字，此处操作等同于left与j下标的数字交换  ArrayUtil.swap(numbers, left, j); 若替换成随机选取出来的pivot则不然
		numbers[left] = numbers[j];
		numbers[j] = pivot;
		return j;
	}

	public static void quickSort(int a[], int left, int right) {
		if (left < right) {
			int center = partition(a, left, right);
			// 左右两半部分，递归进行
			quickSort(a, left, center - 1);// 左半部分
			quickSort(a, center + 1, right);// 右半部分
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51 };
		quickSort(numbers, 0, numbers.length - 1);
		ArrayUtil.print(numbers);
	}
}
