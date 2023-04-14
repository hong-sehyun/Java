package chapter7.abstraction;

import java.util.Scanner;

public class Mission7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.print("입력 : " + N + " * ");

		for (int i = N - 1; i > 1; i--) {

			System.out.print(i + " * ");

		}
		System.out.print(1 + " = ");

		int M = 1;
		for (int j = 1; j < N + 1; j++) {
			M *= j;
		}
		System.out.println(M);

		sc.close();
	}

}
