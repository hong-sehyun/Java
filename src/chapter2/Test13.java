package chapter2;

public class Test13 {

	public static void main(String[] args) {

		byte a = 0b1011;
		byte b = 0b1101;
		
		int c = a & b;
		System.out.println("c = " + c);

		System.out.println(Integer.toBinaryString(c));

		

		
		int e = a^b;
		System.out.println(e);
		System.out.println(Integer.toBinaryString(e));
		
		int f = 12;
		int g = (~f)+1;
		System.out.println(g);
		System.out.println(Integer.toBinaryString(g));
		
		
		
		char j = 'A'; //아스키코드는 65
		int n = j;
		System.out.println(n);		
		j ^= (1<<5); //아스키코드 값이 97
		System.out.println(j);
		
		
		
		
		char x = 'F';
		String gender = (x == 'F') ? "여자" : "남자";
			System.out.println(gender);


		
	}

}
