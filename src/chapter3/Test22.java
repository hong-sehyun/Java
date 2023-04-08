package chapter3;

import java.util.Scanner;

public class Test22 {

	public static void main(String[] args) {
		System.out.println("Op(+, -, *, /)");

		Scanner sc = new Scanner(System.in);
		
		int a = 12;
		int b = 2;
		String op = sc.next();
		
		switch(op) {
		case "+": 
			System.out.println(a + b);break;
			
		case "-": 
			System.out.println(a - b);break;
			
		case "*": 
			System.out.println(a * b);break;
			
		case "/": 
			System.out.println(a / b);break;
			
		default:
			System.out.println("잘못된 연산자 입니다.");
			break;
		
		}
		
		sc.close();
	}

}
