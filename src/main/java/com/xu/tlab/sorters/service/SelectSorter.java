package com.xu.tlab.sorters.service;

import com.xu.tlab.sorters.util.ArrayUtil;

public class SelectSorter {

	/**
	 * <p>
	 * ѡ������
	 * </p>
	 * 
	 * <p>
	 * ѡ�������˼����ʵ��ð�������е����ƣ�������һ����������С��Ԫ�طŵ���ǰ�档<br>
	 * ���ǹ��̲�ͬ��ð��������ͨ�����ڵıȽϺͽ�����<br>
	 * ��ѡ��������ͨ���������ѡ��
	 * </p>
	 * 
	 * <p>
	 * �ٸ����ӣ���5,3,8,6,4����������н��м�ѡ������<br>
	 * ����Ҫѡ��5�������С������5������Ҳ����ѡ��3��5������һ�������ͱ����3,5,8,6,4.<br>
	 * ��ʣ�µ�����һ�ν���ѡ��ͽ��������վͻ�õ�һ���������С�<br>
	 * ��ʵѡ��������Կ���ð��������Ż�����Ϊ��Ŀ����ͬ��<br>
	 * ֻ��ѡ������ֻ����ȷ������С����ǰ���²Ž��н������������˽����Ĵ�����<br>
	 * ѡ�������ʱ�临�Ӷ�ΪO(n^2)
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
		ArrayUtil.println( numbers );
	}
}
