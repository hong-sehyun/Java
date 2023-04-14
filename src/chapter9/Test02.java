package chapter9;

public class Test02 {

	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = "Java";
		
		String s3 = new String("Java");
		String s4 = "Java";
		
		if(s1 == s3) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		
		
		System.out.println("s1 hashCode : " + s1.hashCode());
		System.out.println("s3 hashCode : " + s3.hashCode());
		System.out.println("s1 identityHashCode : " + System.identityHashCode(s1));
		System.out.println("s3 identityHashCode : " + System.identityHashCode(s3));


		
		System.out.println(s1.toString() +"::"+ s3.toString());


		
		if(s2 == s4) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		

	}

}
