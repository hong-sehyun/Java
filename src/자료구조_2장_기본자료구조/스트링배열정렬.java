package algorithm_ch2;

public class 스트링배열정렬 {


	static void showData(String [] data) {
		// 난수 생성하여 배열에 입력
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	
	
	static void sortData(String[] items) {
		String temp = null;
		for (int i = 1;  i < items.length; i++) {
			for(int j = 0; j <= items.length-1; j++) {
				if(items[j].compareTo(items[i]) > items[i].compareTo(items[j])) {
					temp = items[i];
					items[i] = items[j];
					items[j] = temp;
					
				}
			}
		}
	}

	public static void main(String[] args) {

		String [] data = {"watermelon", "apple", "grape", "melon" };
		showData(data);
		sortData(data);
		System.out.println("\nABC 순으로 정렬");
		showData(data);
	}

}
