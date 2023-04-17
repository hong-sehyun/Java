package chapter7.abstraction;

import java.util.Scanner;

public class Mission8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[10];
		int y = 3;
		int z = 5;

		for (int i = 0; i < x.length; i++) {
			int[i] x = 2;

			System.out.println(n / x[i]);
			System.out.println(n / y);
			System.out.println(n / z);

		}
		sc.close();
	}

}
