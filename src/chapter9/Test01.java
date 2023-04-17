package chapter9;

public class Test01 {
	class MyObject {
		int num;

		public MyObject(int num) {
			this.num = num;
		}

		public String toString() {
			return "MyObject";
		}
	}

	public static void main(String[] args) {
//		Test01 t = new Test01();
//		MyObject my = t.new MyObject();
		MyObject my1 = new MyObject(123);
		MyObject my2 = new MyObject(123);
		if (my1.equals(my2))
			System.out.println("my1 같다 my2");
		else
			System.out.println("다르다");

//		my.equals(my);
//		System.out.println("MyObject = " + my);

//		Object obj1 = new Object();
//		Object obj2 = new Object();
//		Object obj3 = new Object();
//		Class c = obj1.getClass();
//		System.out.println(obj1.equals(obj3));

//		System.out.println(obj1);

		if (my1 == my2)
			System.out.println("같다");
		else
			System.out.println("다르다");

//		System.out.println(obj1.hashCode());
//		System.out.println(obj2.hashCode());
//		System.out.println(obj3.hashCode());
//
//		System.out.println(c.getName());
	}
}
