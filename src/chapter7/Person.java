package chapter7;

public class Person {

	private String name;
	private int age;

	public Person() {
		System.out.println("Person생성자 실행");
	}
//	부모클래스의 생성자는 무조건 호출됨!
	

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person생성자1 실행");

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
//	public static void main(String[] args) {
//		Person p = new Person();
//		p.setName("홍길동");
//		p.setAge(20);
//		
//		System.out.println(p);
//	}

}
