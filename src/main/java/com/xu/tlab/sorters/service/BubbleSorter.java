package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class BubbleSorter {

	/**
	 *<p>冒泡排序</p>
	 *
	 *<p>
	 *冒泡排序是最简单的排序之一了，其大体思想就是通过与相邻元素的比较和交换来把小的数交换到最前面。<br>
	 *这个过程类似于水泡向上升一样，因此而得名。
	 *</p>
	 *
	 *<p>
	 *举个栗子，对5,3,8,6,4这个无序序列进行冒泡排序。<br>
	 *从后向前冒泡，4和6比较，把4交换到前面，序列变成5,3,8,4,6。<br>
	 *同理4和8交换，变成5,3,4,8,6,3和4无需交换。<br>
	 *5和3交换，变成3,5,4,8,6,3.这样一次冒泡就完了，把最小的数3排到最前面了。<br>
	 *对剩下的序列依次冒泡就会得到一个有序序列。冒泡排序的时间复杂度为O(n^2)。
	 *</p> 
	 */
	public static void bubbleSort( int[] numbers ) {

		for( int i = 0; i < numbers.length - 1; i++ ) {

			for( int j = numbers.length - 1; j > 0; j-- ) {

				if( numbers[ j - 1 ] > numbers[ j ] ) {
					ArrayUtil.swap( numbers, j - 1, j );
				}
			}
		}

	}

	public static void main( String[] args ) {
		int[] numbers = new int[] { 1, 4, 8, 7, 2, 5, 6 };
		bubbleSort( numbers );
		ArrayUtil.println( numbers );
	}
}
