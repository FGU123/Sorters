package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class InsertSorter {

	/**
	 * <p>��������</p>
	 * 
	 * <p>
	 * ����������ͨ������λ�ö���ͨ���Ƚ��ҵ����ʵ�λ�ò���Ԫ�����ﵽ�����Ŀ�ĵġ�<br>
	 * ���Ŵ�Ҷ��й����˿��Ƶľ������ر��������ϴ�ġ��ڷ���ʱ����Ҫ�����Լ����ƣ�<br>
	 * �ƶ��ʱ����ô�����أ������õ�һ���ƣ��ҵ�һ�����ʵ�λ�ò��롣<br>
	 * ���ԭ����ʵ�Ͳ���������һ���ġ�
	 * </p>
	 * 
	 * <p>
	 * �ٸ����ӣ���5,3,8,6,4����������н��м򵥲�������<br>
	 * ���ȼ����һ������λ��ʱ��ȷ�ģ���һ�����õ���һ���Ƶ�ʱ��û��Ҫ����<br>
	 * Ȼ��3Ҫ�嵽5ǰ�棬��5����һλ�����3,5,8,6,4.��һ�������Ƶ�ʱ��Ӧ��Ҳ�������ɡ�<br>
	 * Ȼ��8���ö���6����8ǰ�棬8����һλ��4����5ǰ�棬��5��ʼ�������һλ��<br>
	 * ע���ڲ���һ������ʱ��Ҫ��֤�����ǰ������Ѿ�����<br>
	 * �򵥲��������ʱ�临�Ӷ�Ҳ��O(n^2)��
	 * </p> 
	 */
	public static void insertSort( int[] numbers ) {

		for( int i = 0; i < numbers.length; i++ ) {

			int j = i;

			int target = numbers[ i ];

			// �ѱ�target����������ƣ��ڱȽϲ������ͣ������λ�õ���������target
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
