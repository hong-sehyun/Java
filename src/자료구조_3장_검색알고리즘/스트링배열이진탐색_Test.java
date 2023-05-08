package 자료구조_3장_검색알고리즘;

import java.util.Arrays;

public class 스트링배열이진탐색_Test {
	static void showData(String [] data) {		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	static void sortData(String [] data) {
		String tmp = null;
		for(int i = 1; i < data.length; i++) {
			for(int j = 0; j < data.length - i; j++) {
				if(data[j].compareTo(data[j+1]) > data[j+1].compareTo(data[j])) {
					tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
					
			}
		}
	}
	
	static String linearSearch(String [] data, String key) {
		for(int i = 0; i < data.length; i++) {
			if(data[i].compareTo(key) == 0) return key;
		}
		return null;
	}
	
	static String binarySearch(String [] data, String key) {
		int n = data.length;
		int pc = n/2;
		do {	
			if(data[pc].compareTo(key) == 0) return key;
			else if(data[pc].compareTo(key) < 0) pc += 1;
			else pc -= 1;
		} while (pc <= data.length);
		return null;
	}

	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "감", "배", "사과", "포도", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData(data);
		sortData(data);
		showData(data);
		
		String key = "감";
		String result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}

}
