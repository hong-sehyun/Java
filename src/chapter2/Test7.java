package chapter2;

public class Test7 {

	public static void main(String[] args) {

		int a = 10;
    	a++;
		System.out.println(a);
		++a;
		System.out.println(a);
		
		int b = 10;
		b--;
		System.out.println(b);
		--b;
		System.out.println(b);
		
		int c = 10;
		int d = 10;
		
		System.out.println(++c);
		System.out.println(d++);

		
		int n = 10;
		System.out.println("n++ = " + n++);
		System.out.println("++n = " + ++n); //27번째 줄의 결과를 반영한 값이 12. 만약 27번째 줄을 지우면 값은 11이 나옴.
		
		n++;
		++n;
		System.out.println("n = " + n);
		
	}

}
