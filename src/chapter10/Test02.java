package chapter10;

import java.util.ArrayList;
import java.util.Iterator;

//p478 Iterator 실습
//p481~488 그냥 넘어감

public class Test02 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("부산");
		list.add("제주");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println("==============");
		list.add(0, "대구");
		System.out.println(" : ");

		String[] sl = new String[10];
		sl[0] = "서울";
		sl[1] = "부산";

		for (String sx : sl) {
			System.out.print(" " + sx);
		}

		// sl[0]에 대구를 입력하려면
		sl[2] = sl[1]; sl[1]=sl[0];
		sl[0] = "대구"; 
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) { // hasnext: 커서의 값을 반환함
			System.out.print(" " + iter.next());
		}
	}

}
