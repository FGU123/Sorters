package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class SelectSorter {

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
		ArrayUtil.println( numbers );
	}
}
