package com.ruby.java.ch06;

class Count {
	public static int totalCount;
	private int num;
	public void setNum(int n) {
		num = n;
	}
	public int getNum() {
		return num;
	}// 퍼블릭은 클래스 박에서 사용가능, get~: 리턴값
}

public class CountTest {
	public static void show() {  //함수도 static 사용 사능(클래스 매서드)
		System.out.println("Hello");
	}
	public static void main(String[] args) {
		CountTest.show();
		int num = 0;
		Count.totalCount = 20;
//		Count.num = 10;
		Count c1 = new Count();
//		Count c2 = new Count();
//		Count c3 = new Count();

//		c1.num++;
		c1.setNum(num);
		System.out.println("Num : " + c1.getNum());
		Count.totalCount++;
//		c2.num++;
//		Count.totalCount++;
//		c3.num++;
//		Count.totalCount++;
//
//		System.out.println(Count.totalCount + " : " + c1.num);
//		System.out.println(Count.totalCount + " : " + c2.num);
//		System.out.println(Count.totalCount + " : " + c3.num);
	}
}
