package datastructure;

import java.util.Scanner;

public class Code18_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];

		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		
		bubbleSort( n, data );
		
		
		System.out.println("정렬된 데이터 : ");
		for (int i = 0; i < n; i++)
			System.out.println(data[i]);
	}
	
	static void bubbleSort( int n, int[] arr ) {
		for(int i = n-1; i > 0; i--) {
			for(int j = 0; j < n; j++) {
				if(data[j]>data[j+1]) {
					//swap data[j] and data[j+1]
					swap (data[j], data[j+1]);
					
				}					
			}
		}	
	}
	//작동하지 않음 참조에 의한 호출이 아닌 값에 의 한 호출익 때문
	//자바와 c는참조에 의한 호출을 지원하지 않
	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}