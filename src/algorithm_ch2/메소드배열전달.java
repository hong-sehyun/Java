package algorithm_ch2;

import java.util.Random;

public class 메소드배열전달 {
	static void getData(int[] data) {
		// 난수 생성하여 배열에 입력
		Random rd = new Random(99);
		for (int i = 0; i < data.length; i++) {
			data[i] = rd.nextInt(10);
		}

	}

	static void showData(int[] data) {
		// 난수 생성하여 배열에 입력
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	static int findMax(int[] data) {
		int max = 0;
		for (int i = 0; i < data.length; i++) {
			if (max < data[i])
				max = data[i];
		}
		return max;
	}
	
	
	static void swap(int[] data, int a, int b) {
		
		int tmp;
		for (int i = 0; i < data.length; i++) {
			for(int j = i+1; j <= data.length; j++) {
				if(data[i]>data[j]) {
					tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}
		}
		
		/*
		int tmp = a;
		a = b;
		b = tmp;
		*/
	}
	static void sortData(int[] data) {

		for (int i = 0;  i< data.length; i++) {
			for (int j = i+1; j <= data.length; j++) {			
				if(data[i]>data[j]) {
					swap(data, data[i], data[j]);
				}
				
			} 
		}
	}

	public static void main(String[] args) {

		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println("\nmax = " + mvalue);
		sortData(data);
		System.out.println("\n정렬 후 결과");
		showData(data);
	}

}
