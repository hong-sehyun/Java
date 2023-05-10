package 자료구조_3장_검색알고리즘;

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	String name;
	int price;
	String expire;
	
//	//static이면 객체가 여러개 만들어져도 하나 만 있음(공유 변수) 
//	public static final Comparator<Fruit> Class_cc = new ComparatorFruit();
//	private static class ComparatorFruit implements Comparator<Fruit> {// 익명클래스 사용
//		
//		@Override
//		public int compare(Fruit f1, Fruit f2) {
//			return (f1.expire.compareTo(f2.expire));
//		}
//	};

	public Fruit(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
		

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

//	public static Comparator<Fruit> getClassCc() {
//		return Class_cc;
//	}

	@Override
	public String toString() {
		return "[" + name + ", " + price + ", " + expire + "]";
	}

	public void showData() {
		System.out.println(this.toString());
	}


}

public class Fruit객체배열이진탐색_Test {
	static void showData(Fruit [] arr) {
		// 난수 생성하여 배열에 입력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	static void swap(Fruit [] data, int i, int j) {
		Fruit tmp = null;

		tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static void main(String[] args) {
		
		Fruit[] arr = {
		        new Fruit("사과", 200, "2023-5-08"),
		        new Fruit("키위", 500, "2023-6-08"),
		        new Fruit("오렌지", 200, "2023-7-08"),
		        new Fruit("바나나", 50, "2023-5-18"),
		        new Fruit("수박", 880, "2023-5-28"),
		        new Fruit("체리", 10, "2023-9-08")
		};

		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("\n람다식 정렬(가격)후 객체 배열: ");
		showData(arr);

		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData(arr);

		// ccname은 변수고 익명 클래스의 객페를 가지고 있음
		Comparator<Fruit> cc_name = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return (f1.name.compareTo(f2.name));
			}
		};
		Comparator<Fruit> cc_price = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return (f1.price - f2.price);
			}
		};

		Comparator<Fruit> cc_expire = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit f1, Fruit f2) {
				return (f1.expire.compareTo(f2.expire));
			}
		};

		Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
		
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		sortData(arr, cc_price);
		
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
		
		sortData(arr, cc_expire);
		
		System.out.println("\ncomparator 정렬(유통기한)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_expire);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_expire);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
		
		
	}
	
	static void sortData(Fruit [] arr, Comparator<? super Fruit> cc ) {
		
		for (int i = 0; i < arr.length; i++) {
			for(int j =i +1 ; j < arr.length; j++) {
				Fruit d1 = arr[i];
				Fruit d2 = arr[j];
				if(cc.compare(d1, d2) > 0 ) {						
					swap (arr, i, j);
				}
			}
		}	
	}

	static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<? super Fruit> cc) {
		// 이진탐색 코드 가져와서 Fruit 버전으로 변경
		// if문에서 비교할때
		/*
		int n = arr.length;
		int pc = n/2;
		
		for(int i = 0; i < pc; i++) {
			for(int j = pc + 1; j < arr.length; j++) {

				if(cc.compare(d1, d2) == 0) return pc;
				else if(cc.compare(d1, d2) < 0) pc += 1;
				else pc -= 1;
			}
		} return -1;
		*/
		int n = arr.length;
		int pc = n/2;
		do {	
			if(cc.compare(arr[pc], newFruit) == 0) return pc;
			else if(cc.compare(arr[pc], newFruit) < 0) pc += 1;
			else pc -= 1;
		} while (pc <= arr.length);
		return -1;
	}
}
