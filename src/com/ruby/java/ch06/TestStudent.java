package com.ruby.java.ch06;

//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
class StudentA {
	private static int countStudents = 5;// 객체수
	private int sid;// 학번
	private String sname; // 학생 이름
	private String city; // 주소 도시

	public static void showNumberObjects() {// 생성된 객체수를 출력한다.
		System.out.println(countStudents);
	}

	public StudentA() {

		this.sid = 0;
		this.sname = null;
		this.city = null;

	}

	public StudentA(int sid) {
		this.sid = sid;
		this.sname = null;
		this.city = null;
	}

	public StudentA(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
		this.city = null;
	}

	public StudentA(int sid, String sname, String city) {
		this.sid = sid;
		this.sname = sname;
		this.city = city;
	}

	public String toString() {
		return "sid = " + sid + ", sname = " + sname + ", city = " + city;
	}

	public void showStudent(String toString) {
		System.out.println("객체: " + countStudents);
		this.toString();

	}
}

public class TestStudent {

	public static void main(String[] args) {

		 Student arry[] = new Student[5];

		 arry[0] = new Student();
		 arry[1] = new Student(202301);
		 arry[2] = new Student(202302, "Hong");
		 arry[3] = new Student(202303, "Lee", "Busan");
		 arry[4] = new Student(202304, "Na", "jeju");
//		StudentA s1 = new StudentA();
//		StudentA s2 = new StudentA(202301);
//		StudentA s3 = new StudentA(202302, "Hong");
//		StudentA s4 = new StudentA(202303, "Lee", "Busan");
//		StudentA s5 = new StudentA(202304, "Na", "jeju");


//
//		System.out.println(s1.showStudent());
//		System.out.println(s2.showStudent());
//		System.out.println(s3.toString());
//		System.out.println(s4.toString());
//		System.out.println(s5.toString());

		 
		 for (int i = 0; i < 5; i++) {
			 arry[i].showStudent();    //생성된 객체 모두를 출력한다.
		 }

	}

}
