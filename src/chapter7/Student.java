package chapter7;

public class Student extends Person {
	
	public Student() {
		System.out.println("Student생성자 실행");
	}
	
	private String major;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [name=" + getName() + ", age=" + getAge() +", major=" + major + "]";
	}
	
	
}
