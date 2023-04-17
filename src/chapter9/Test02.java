package chapter9;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = "Java";
		
		String s3 = new String("Java");
		String s4 = "Java";
		
		if(s1.equals(s3)) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		
		System.out.println("s1 hashCode : " + s1.hashCode());
		System.out.println("s3 hashCode : " + s3.hashCode()); //hashCode 가 같은 이유: 코드 최적화
		
		System.out.println("s1 identityHashCode : " + System.identityHashCode(s1));
		System.out.println("s3 identityHashCode : " + System.identityHashCode(s3));


		
		System.out.println(s1.toString() +"::"+ s3.toString());


		
		if(s1 == s3) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		

		int i3 = Integer.parseInt("123");
		
		Arrays.binarySearch(null, 0);
		Arrays.sort(null);
	}

}
