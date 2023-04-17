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

	public void showStudentA() {
		System.out.println("객체: " + countStudents);		
		System.out.println(this.toString());

	}
}

public class TestStudent {

	public static void main(String[] args) {

		StudentA arry[] = new StudentA[5];

		arry[0] = new StudentA();
		arry[1] = new StudentA(202301);
		arry[2] = new StudentA(202302, "Hong");
		arry[3] = new StudentA(202303, "Lee", "Busan");
		arry[4] = new StudentA(202304, "Na", "jeju");

		for (int i = 0; i < 5; i++) {
			arry[i].showStudentA(); // 생성된 객체 모두를 출력한다.
		}

	}

}
