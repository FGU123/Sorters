package com.xu.tlab.sorters.service;

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

		int pivot = numbers[left], i = left + 1, j = right;

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

			swap(numbers, i, j);
		}
		
		swap(numbers, left, j);
		return j;
	}

	public static void quickSort(int a[], int left, int right) {
		if (left < right) {
			int center = partition(a, left, right);
			quickSort(a, left, center - 1);// 左半部分
			quickSort(a, center + 1, right);// 右半部分
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 2, 6, 4, 7, 83, 15, 78, 9, 10, 32, 11, 0, 51 };
		quickSort(numbers, 0, numbers.length - 1);
	}
	
	private static void swap( int[] array, int i, int j ) {
		int tmp = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = tmp;
	}
}
