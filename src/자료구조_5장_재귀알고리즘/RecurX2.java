package 자료구조_5장_재귀알고리즘;

import java.util.Scanner;

class RecurX2 {

	static void recur(int n) {

		IntStack s = new IntStack(n);
		while (true) {
			if (n > 0) {
				s.push(n);
				System.out.println("recur(" + n + "-1 );");
				n = n - 1;
				
				continue;
				
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				System.out.println("recur(" + n + "-2 );");
				n = n-2;

				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 :");
		int x = sc.nextInt();

		recur(x);

		sc.close();
	}

}
