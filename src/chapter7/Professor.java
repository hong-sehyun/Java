package chapter7;

public class Professor extends Person {
	
	public Professor() {
		System.out.println("Professor생성자 실행");
	}
	
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Professor [name=" + getName() + ", age=" + getAge() +", subject=" + subject + "]";
	}
	
	
}
