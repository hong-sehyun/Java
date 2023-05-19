package 자료구조_5장_재귀알고리즘;

import java.util.Scanner;

class Factorial {
	static int factorial(int n) {
		return ((n>0 )? n * factorial(n - 1) : 1);
//		if (n > 0)
//			return n * factorial(n - 1);
//		else
//			return 1;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("정수를 입력하세요 : ");
		int x = sc.nextInt();
		int result = factorial(x);
		System.out.println(x + "의 펙토리얼은 " + result + "입니다.");
		
		sc.close();
	}
}
