package chapter10;
//LinkedList 실습
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test05 {
	public static void print(int n, LinkedList<String> list) {
		System.out.println();
		System.out.println(n + " : "+ list.toString());
	}
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("서울");
		list.add("부산");
		list.add("제주");
		
		list.add(0, "LA");
		
		for(String sx : list) {
			System.out.print(" " + sx);
		}
		print(1, list);
		
		List<String> list2 = Arrays.asList("북경", "상해");
		list.addAll(list2);
		print(2, list);			
		Object obj[] = list.toArray();
		System.out.println("배열 출력 " + Arrays.toString(obj));

	}

}
