package Doit_algorithm;

import java.util.Scanner;

public class Ch01ex9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("a값 : ");
		int a = sc.nextInt();
		int b;
		do {
			System.out.println("b값: ");
			b = sc.nextInt();
			if(b <= a)
				System.out.println("a보다 큰 값을 입력하세요!");
		}while(b <= a);
		
		System.out.println("b-a는 "+ (b-a) +"입니다.");
		
		sc.close();
	}

}
