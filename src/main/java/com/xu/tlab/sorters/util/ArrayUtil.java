package com.xu.tlab.sorters.util;

public class ArrayUtil {

	public static void println( int[] array ) {
		for( int j = 0; j < array.length; j++ ) {
			System.out.println( array[ j ] );
		}
	}
	
	public static void print( int[] array ) {
		for( int j = 0; j < array.length; j++ ) {
			if( j == 0 ) {
				System.out.print( array[ j ] );
			} else {
				System.out.print( ", " + array[ j ] );
			}
		}
	}

	public static void swap( int[] array, int a, int b ) {
		int tmp = array[ a ];
		array[ a ] = array[ b ];
		array[ b ] = tmp;
	}
}
