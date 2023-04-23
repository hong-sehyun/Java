package datastructure;

import java.util.Scanner;

public class Code16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int result = power(a, b);

		System.out.println(result);
		sc.close();
	}
	
	static int power( int n, int m )
	{
		int prod = 1;
		for(int i = 0; i < m; i++) {
			prod *= n;    // prod = prod * n
		}
		
		return prod;
	} 
} 
