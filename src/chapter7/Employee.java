package chapter7;

public class Employee extends Person {
	
	private String dept;
	
	public Employee() {
		System.out.println("Employee생성자 실행");
	}
//	부모생성자(Person)가 먼저 생성된 다음 생성됨.
	
	public Employee(String name, int age, String dept) {
//		setName(name);
//		setAge(age);
		super(name, age); // 부모클래스를 호출하는 일반적인 방법
		this.dept = dept;
	}



	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
//	public void setDept(String dep) {
//		dept = dep;
//	}
	//this 없이 이렇게 쓰는 것도 가능함

	@Override
	public String toString() {
		return "Employee [name=" + getName() + ", age=" + getAge() + ", dept=" + dept + "]";
	}
	
}
