package chapter14;

interface MyInterface {
	public void print();
}


  class MyClass1 implements MyInterface {
  
  @Override public void print() { System.out.println("MyClass1"); } }
  
  class MyClass2 implements MyInterface {
  
  @Override public void print() { System.out.println("MyClass2"); } 
  
//  mi.print();
 
  }
public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}

	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {

			@Override
			public void print() {
				System.out.println("리턴 객체");
			}
		};
		return mi;
	}

	public static void main(String[] args) {
//		/*
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스 구현");
			}
		};

//		*/

		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스 구현");
			}
		}).print();

		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		mc2.print();
		mi.print();
		test(mc1);
		test(mi);
		test2().print();
		MyInterface m = test2();
		m.print();
		MyInterface m = () ->System.out.println("hello");

	}
}
