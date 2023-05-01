package chapter14;

/*
@FunctionalInterface //<<override 와 같은 annotation
interface Multiply {
	double getValue();
//람다식을 쓸 땐 인터페이스 함수가 하나여야 됨.
}
*/


@FunctionalInterface 
interface verify {
	boolean check(int n);
}

public class Test02 {
public static void main(String[] args) {
	verify v = (n) -> (n % 2) == 0;
	System.out.println(v.check(10));
	System.out.println("v = " + v);
	
	/*
	Multiply m;
	m = () -> 3.14 * 2;
	System.out.println(m.getValue());
	System.out.println("m = " + m);
	*/

	/* 
	m = () -> 10 * 3;
	System.out.println(m.getValue());
	*/
}
}
