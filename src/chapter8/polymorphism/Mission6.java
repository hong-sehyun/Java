package chapter8.polymorphism;

import java.util.Scanner;

public class Mission6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();

//		if(A == 1) 		System.out.println("입력 : "+ A + "→" + A);
//		else if(2 <= A && A < 4) 		System.out.println("입력 : "+ A + "→" + "1" + A%2);

//		if (A % 2 == 0) {
//			System.out.print("입력 : ");
//			System.out.print(A);
//			System.out.print(" → ");
//			System.out.print("1");
//			for (int i = 1; i < A / 2; i++)
//				System.out.print("0");
//		}
//		
//		else if (A%2 == 1) {
//			System.out.print("입력 : ");
//			System.out.print(A);
//			System.out.print(" → ");
//			System.out.print("1");
//			for (int i = 1; i < (((A-1) / 2)-1); i++)
//				System.out.print("0");
//			
//			
//			System.out.print("1");
//
//		}
//		int odd = 0;
//		int evn = 0;

		if (A % 2 == 0) {
			System.out.print("입력 : ");
			System.out.print(A);
			System.out.print(" → ");
			System.out.print("1");
			for (int i = 1; i < ((A / 2) - 1); i++) {
				if ((A /= 2) == 0)
					System.out.print("1");
				else
					System.out.print("0");

			}
			System.out.print("0");
		}

		sc.close();
	}

}
