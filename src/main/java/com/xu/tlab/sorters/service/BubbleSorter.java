package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class BubbleSorter {

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
