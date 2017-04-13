package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class InsertSorter {

	/**
	 * <p>插入排序</p>
	 * 
	 * <p>
	 * 插入排序不是通过交换位置而是通过比较找到合适的位置插入元素来达到排序的目的的。<br>
	 * 相信大家都有过打扑克牌的经历，特别是牌数较大的。在分牌时可能要整理自己的牌，<br>
	 * 牌多的时候怎么整理呢？就是拿到一张牌，找到一个合适的位置插入。<br>
	 * 这个原理其实和插入排序是一样的。
	 * </p>
	 * 
	 * <p>
	 * 举个栗子，对5,3,8,6,4这个无序序列进行简单插入排序，<br>
	 * 首先假设第一个数的位置时正确的，想一下在拿到第一张牌的时候，没必要整理。<br>
	 * 然后3要插到5前面，把5后移一位，变成3,5,8,6,4.想一下整理牌的时候应该也是这样吧。<br>
	 * 然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。<br>
	 * 注意在插入一个数的时候要保证这个数前面的数已经有序。<br>
	 * 简单插入排序的时间复杂度也是O(n^2)。
	 * </p> 
	 */
	public static void insertSort( int[] numbers ) {

		for( int i = 0; i < numbers.length; i++ ) {

			int j = i;

			int target = numbers[ i ];

			// 把比target大的数都后移，在比较操作最后停下来的位置的数，换成target
			while( j > 0 && target < numbers[ j - 1 ] ) {
				numbers[ j ] = numbers[ j - 1 ];
				j--;
			}
			numbers[ j ] = target;
		}

	}

	public static void main( String[] args ) {
		int[] numbers = new int[] { 1, 4, 8, 7, 2, 5, 6 };
		insertSort( numbers );
		ArrayUtil.println( numbers );
	}
}
