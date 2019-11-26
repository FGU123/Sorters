package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class SelectSorter {

	/**
	 * <p>
	 * 选择排序：
	 * 区分已排序和未排序两类序列，每次只从未排序的数字中取出最小(大)的数字，
	 * 添加到已排序的序列后面，最终达到全部有序。
	 * </p>
	 * 
	 * <p>
	 * 选择排序的思想其实和冒泡排序有点类似，都是在一次排序后把最小的元素放到最前面。<br>
	 * 但是过程不同，冒泡排序是通过相邻的比较和交换。<br>
	 * 而选择排序是通过对整体的选择。
	 * </p>
	 * 
	 * <p>
	 * 举个栗子，对5,3,8,6,4这个无序序列进行简单选择排序。<br>
	 * 首先要选择5以外的最小数来和5交换，也就是选择3和5交换，一次排序后就变成了3,5,8,6,4.<br>
	 * 对剩下的序列一次进行选择和交换，最终就会得到一个有序序列。<br>
	 * 其实选择排序可以看成冒泡排序的优化，因为其目的相同，<br>
	 * 只是选择排序只有在确定了最小数的前提下才进行交换，大大减少了交换的次数。<br>
	 * 选择排序的时间复杂度为O(n^2)
	 * </p>
	 */
	public static void selectSort( int[] numbers ) {

		for( int i = 0; i < numbers.length - 1; i++ ) {
			
			int minIndex = i;

			for( int j = i + 1; j < numbers.length; j++ ) {
				if( numbers[ j ] < numbers[ minIndex ] ) {
					minIndex = j;
				}
			}

			ArrayUtil.swap( numbers, minIndex, i );
		}
	}

	public static void main( String[] args ) {
		int[] numbers = new int[] { 1, 4, 8, 7, 2, 5, 6 };
		selectSort( numbers );
		ArrayUtil.print( numbers );
	}
}
