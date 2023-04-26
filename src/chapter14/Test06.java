package chapter14;
// 제너릭 함수형 인터페이스

/*
interface StringFunc {
	String modify(String s);
}
interface IntegerFunc {
	Integer modify(Integer s);
}
*/

interface MyFunc<T> {
	T modify (T t);
}

public class Test06 {

	public static void main(String[] args) {
		MyFunc<String> mf1 = ( str ) -> str.toUpperCase() + ": " + str.length();
		System.out.println(mf1.modify("Java"));
		System.out.println(mf1.modify("Java programming"));

		MyFunc<Integer> mf2 = (n) -> n *2;
		System.out.println(mf2.modify(23));
		System.out.println(mf2.modify(42));
	}

}
