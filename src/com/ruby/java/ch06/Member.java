package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;

	public Member() {
//		this.name = null;
//		this.age = 0;
		this(null);
	}

	public Member(String name) {
//		this.name = name;
//		this.age = 0;
		this(name, 0); //생성자 함수 호출
	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "name = " + name + ", age = " + age;
	}

	public static void main(String[] args) {
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Bobby", 23);
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}
