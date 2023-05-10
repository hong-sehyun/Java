package 자료구조_3장_검색알고리즘;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;
	
	@Override
	public int compareTo(PhyscData pd) {
		int result = this.name.compareTo(pd.name);
		if (result == 0) {
			int hresult = this.height - pd.height;
			if(hresult == 0) {
				return (int)(this.vision - pd.vision);
			}
			else return hresult;
		}
		else return result;
	}
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + height + ", " + vision + "]";
	}

	public void showData() {
		System.out.println(this.toString());
	}
	
	
//	@Override
//	public int compareTo(PhyscData d1) {
//		if(this.name.compareTo(d1.name) == 0) {
//			if(this.height == d1.height) {
//				if(this.vision == d1.vision) 
//					return 0;
//					if(this.vision > d1.vision) return 1;
//					else return -1;
//			} else if(this.height > d1.height) return 1;
//			  else return -1;
//		} 
//		 
//		else if (this.name.compareTo(d1.name) > 0) 
//			return 1; 
//		else return -1;
//	}
	
}

public class 객체배열이진탐색_Test {
	
		// static - 객체가 없어도 쓸수있음
		static void swap(PhyscData[] data, int i, int j) {
			PhyscData tmp = null;

			tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;

		}
		static void sortData(PhyscData[] data) {
			
			for (int i = 0; i < data.length; i++) {
				for(int j =i +1 ; j < data.length; j++) {
					if(data[i].compareTo(data[j]) > 0) {						
						swap (data, i, j);
					}
				}
			}	
		}
		
		static int linearSearch(PhyscData[] data, PhyscData key) {
			for(int i = 0; i < data.length; i++) {
				if(data[i].compareTo(key) == 0) return i;
			} return -1;
		}
		
		static int binarySearch(PhyscData [] data, PhyscData key) {
			int n = data.length;
			int pc = n/2;
			do {	
				if(data[pc].compareTo(key) == 0) return pc;
				else if(data[pc].compareTo(key) < 0) pc += 1;
				else pc -= 1;
			} while (pc <= data.length);
			return -1;
		}
		
		static void showData(PhyscData[] data) {
			// 난수 생성하여 배열에 입력
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

	public static void main(String[] args) {
		PhyscData[] data = new PhyscData[7];
			data[0] = new PhyscData("홍길동", 162, 0.3);
			data[1] = new PhyscData("홍동", 164, 1.3);
			data[2] = new PhyscData("홍길", 152, 0.7);
			data[3] = new PhyscData("김홍길동", 172, 0.3);
			data[4] = new PhyscData("길동", 182, 0.6);
			data[5] = new PhyscData("길동", 167, 0.2);
			data[6] = new PhyscData("길동", 167, 0.5);
		
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);
		
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		//Arrays.binarySearch(data, key, cc);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}
//	static void showData(PhyscData[]arr) {
//		System.out.println();
//		for (PhyscData fruit: arr) {
//			System.out.print(fruit+" ");
//		}
//		System.out.println();
//	}
}
