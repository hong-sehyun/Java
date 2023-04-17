package chapter10;

import java.util.ArrayList;
import java.util.Arrays;

class Employee {
	String name;
	int age;
	int height;
	int weight;
	char bloodType;
	String email;

	public Employee(String name, int age, int height, int weight, char bloodType, String email) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
		this.email = email;
	} // 생성자

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + ", bloodType="
				+ bloodType + ", email=" + email + "]";
	}

}

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("부산");
		list.add("창원");
		list.add("서울");
		list.add("울산");
		list.add("밀양");
//		for(String a : list)
//			System.out.println(a.toString());

		for (int i = 0; i < list.size(); i++)
			System.out.println(" " + list.get(i).toString());
		list.add(0, "인천");
		list.remove(1); // 서울 삭제
		System.out.println("\n 인천 삽입 후 ::");
		for (int i = 0; i < list.size(); i++)
			System.out.println(" " + list.get(i).toString());

		System.out.println(list.toString()); //ArrayList에서 제공하는 function
		
		Object obj[] = list.toArray(); //리스트를 배열로 바꿔주고 sysout을 통해 찍겠다는 뜻
		System.out.println("8: "+ Arrays.toString(obj));
		
		
		Object arr[] = new Object[10];
		ArrayList lst = new ArrayList();
		String s = "Java";
		Integer i = 123;
		arr[0] = s;
		arr[1] = i;
		int m = arr.length;
//		int len = arr[0].length(); //p467 보고 하기

		lst.add(s);
		lst.add(i);
		lst.get(0);

		int[] a = new int[10];
		Employee[] eset = new Employee[10];
		eset[0] = new Employee("hong", 11, 130, 50, 'A', "shhong");
		eset[1] = new Employee("kim", 11, 130, 50, 'A', "shhong");
		eset[2] = new Employee("lee", 11, 130, 50, 'A', "shhong");
		eset[3] = new Employee("park", 11, 130, 50, 'A', "shhong");
		eset[4] = eset[3];
		eset[3] = eset[2];

		eset[2] = new Employee("choi", 11, 130, 50, 'A', "shhong"); // 기존의 [2]가 날라감. eset[4] = eset[3]; eset[3] =
																	// eset[2]; 을 넣어줌. 하지만 번거롭고 어려움

		for (int j = 0; j < 5; j++) {
			System.out.println(eset[j].toString());
		}
	}
}
