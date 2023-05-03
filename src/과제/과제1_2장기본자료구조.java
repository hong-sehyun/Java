package 과제;

import java.util.ArrayList;
import java.util.Collections;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}

	public void showData() {
		System.out.println(this.toString());
	}
	
	
	@Override
	public int compareTo(PhyscData d1) {
		if(this.name.compareTo(d1.name) == 0) {
			if(this.height == d1.height) {
				if(this.vision == d1.vision) 
					return 0;
				else if(this.vision > d1.vision) return 1;
				else return -1;
			} else if(this.height > d1.height) return 1;
			  else return -1;
		} 
		 
		else if (this.name.compareTo(d1.name) > 0) 
			return 1; 
		else return -1;
	}
	
}

public class 과제1_2장기본자료구조 {
	// static - 객체가 없어도 쓸수있음

	
	static void showData(PhyscData[] data) {
		// 난수 생성하여 배열에 입력
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " ");
		}
	}

	public static void main(String[] args) {
		

		ArrayList<PhyscData> data = new ArrayList<>();
		
			data.add(new PhyscData("홍길동", 162, 0.3));
			data.add(new PhyscData("홍동", 164, 1.3));
			data.add(new PhyscData("홍길", 152, 0.7));
			data.add(new PhyscData("김홍길동", 172, 0.3));
			data.add(new PhyscData("이길동", 182, 0.6));
			data.add(new PhyscData("박길동", 167, 0.2));
			data.add(new PhyscData("최길동", 169, 0.5));
		

		System.out.println(data);		
		Collections.sort(data);		
		System.out.println(data);
		
//		showData(data);
//		sortData(data);
//		showData(data);
	}

}