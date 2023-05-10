package 자료구조_3장_검색알고리즘;

import java.util.Arrays;

public class 스트링배열이진탐색_Test {
	static void showData(String [] data) {		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	static void swap(String[]data, int i, int j) {
		String tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	static void sortData(String [] data) {
		String tmp = null;
		for(int i = 0; i < data.length; i++) {
			for(int j = i+1; j < data.length; j++) {
				if(data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
			
				}
					
			}
		}
	}
	
	static int linearSearch(String [] data, String key) {
		for(int i = 0; i < data.length; i++)
			if(data[i].compareTo(key) == 0)
				return i;
		return -1;
	}
	
	static int binarySearch(String [] data, String key) {
		int n = data.length;
		int pc = n/2;
		do {	
			if(data[pc].compareTo(key) == 0) return pc;
			else if(data[pc].compareTo(key) < 0) pc += 1;
			else pc -= 1;
		} while (pc <= data.length);
		return -1;
	}

	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "감", "배", "사과", "포도", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData(data);
		sortData(data);
		showData(data);
		
		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}

}
