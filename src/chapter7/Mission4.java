package chapter7;

public class Mission4 {

	public static void main(String[] args) {

		int evensum = 0;
		int oddsum = 0;
		int sum = 0;

		for (int i = 1; i < 1000; i++) {
			sum += i;
			if (i % 2 == 0) evensum += i;
			else oddsum += i;
		}
		System.out.println(sum);
		System.out.println(evensum);
		System.out.println(oddsum);

	}

}
