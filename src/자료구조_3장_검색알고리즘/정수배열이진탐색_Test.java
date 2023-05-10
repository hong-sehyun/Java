package 자료구조_3장_검색알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 정수배열이진탐색_Test {
	
	static void inputData(int [] data) {
//		Random rd = new Random(99);
//		for (int i = 0; i < data.length; i++) {
//			data[i] = rd.nextInt(10);
//		}
		Scanner sc = new Scanner(System.in);
		System.out.println("값을 10개 입력하세요");
		for (int i = 0; i < 10; i ++) {
			data[i] = sc.nextInt();
		}
	}
	
	static void showData(int [] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	static void sortData(int [] data) {
		int tmp;
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data.length - i; j++ ) {
				if (data[j+1] < data[j]) {
					tmp = data[j+1];
					data[j+1] = data[j];
					data[j] = tmp;
				}
			}
		}
	}
	
	static int linearSearch(int[] data, int key) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == key) {
				return key;
			}
		}
		return -1;
	}
	
	static int binarySearch(int[] data, int key) {
		int idx = Arrays.binarySearch(data, key);
		if (idx < 0) return -1;
		else return idx;
	}

	public static void main(String[] args) {
		int [] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for(int num : data) {
			System.out.print(num + " ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}

}
