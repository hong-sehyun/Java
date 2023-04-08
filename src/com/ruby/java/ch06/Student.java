package com.ruby.java.ch06;

public class Student {
	private int sid;
	private String name;
	private String dept;
	public Student() {}  // 디폴트 생성자
	public Student(int sid, String name, String dept) {
		this.sid = sid; this.name = name; this.dept = dept;
		// this 는 클래스에 있는 sid를 가르킴. ex) this.sid는 4행(heap 영역)의 sid를 가르킴.
	}
	public static void main(String[] args) {
		System.out.println("6장 시작");
		int n = 10;
		Student s = null;
//		s = new Student();
		s = new Student(2023,"홍길동", "컴퓨터");
		// 클래스 이름으로 생성자 만들어서 new로 호출(객체를 생성한다는 키워드)
		System.out.println(s.sid);
		s.sid = 99;
		System.out.println(s.sid);

		System.out.println("student 객체 = " + s);
	}
}
