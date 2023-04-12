package chapter7.abstraction;

import java.util.Scanner;

public class Mission5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int price = sc.nextInt();
				
		System.out.println("5만원 * "+ price/50000 + "장");
		System.out.println("1만원 * "+ (price%50000)/10000 + "장");
		System.out.println("5천원 * "+ ((price%50000)%10000)/5000 + "장");
		System.out.println("1천원 * "+ (((price%50000)%10000)%5000)/1000 + "장");

		sc.close();
	}

}
