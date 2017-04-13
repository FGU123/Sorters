package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class BubbleSorter {

	/**
	 *<p>ð������</p>
	 *
	 *<p>
	 *ð����������򵥵�����֮һ�ˣ������˼�����ͨ��������Ԫ�صıȽϺͽ�������С������������ǰ�档<br>
	 *�������������ˮ��������һ������˶�������
	 *</p>
	 *
	 *<p>
	 *�ٸ����ӣ���5,3,8,6,4����������н���ð������<br>
	 *�Ӻ���ǰð�ݣ�4��6�Ƚϣ���4������ǰ�棬���б��5,3,8,4,6��<br>
	 *ͬ��4��8���������5,3,4,8,6,3��4���轻����<br>
	 *5��3���������3,5,4,8,6,3.����һ��ð�ݾ����ˣ�����С����3�ŵ���ǰ���ˡ�<br>
	 *��ʣ�µ���������ð�ݾͻ�õ�һ���������С�ð�������ʱ�临�Ӷ�ΪO(n^2)��
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
