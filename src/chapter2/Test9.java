package chapter2;

public class Test9 {

	public static void main(String[] args) {

		int a =10;
		int b = 2;
		
		boolean gender = true;
		System.out.println(a == 10 && gender == false);
		System.out.println(a == 10 & gender == false);

		
		a+= b;
		System.out.println(a);
		a -= b;
		System.out.println(a);
		a *= b;
		System.out.println(a);
		a /= b;
		System.out.println(a);
		a %= b;
		System.out.println(a);
		
		

		
	}

}
