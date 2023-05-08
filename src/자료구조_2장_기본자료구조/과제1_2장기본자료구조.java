package 자료구조_2장_기본자료구조;


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
		return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
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
					if(this.vision > d1.vision) return 1;
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
static void swap(PhyscData[] data, String name, int height, double vision) {
		
		PhyscData[] tmp = new PhyscData[0];
		tmp[0] = null;
		for (int i = 1; i < data.length; i++) {
			for(int j = 0; j < data.length-1; j++) {
				if(data[j].compareTo(data[i]) > 0) {
					tmp[0] = data[i];
					data[i] = data[j];
					data[i] = tmp[0];
				}
				
				
				//===========================
//				if(data[j].name.compareTo(data[i].name) > data[i].name.compareTo(data[j].name)) {
//					if(data[i].height < data[j].height) {
//						if(data[i].vision < data[j].vision) {
//							tmp[0] = data[i];
//							data[i] = data[j];
//							data[i] = tmp[0];
//						}
//					}
//					
//				}
				

			}
		}
		
		/*
		int tmp = a;
		a = b;
		b = tmp;
		*/
	}
	static void sortData(PhyscData[] data) {
		for (int i = 0;  i< data.length; i++) {
			for (int j = i+1; j <= data.length; j++) {			
				
					swap(data, data.name, data.height, data.vision);
				
			}
		}
	}
	
	static void showData(PhyscData[] data) {
		// 난수 생성하여 배열에 입력
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " ");
		}
	}

	public static void main(String[] args) {
		

		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};

	
		
		showData(data);
		sortData(data);
		showData(data);
	}

}