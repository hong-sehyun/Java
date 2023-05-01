package chapter14;

interface NumberFunc {
	int func (int n);
}

public class Test05 {

	public static void main(String[] args) {
		NumberFunc sum = (n) -> {
			int result = 0;
			for (int i = 0; i <=n; i++) {
				result += i;
			}
			return result;
		};
		System.out.println("sum = " + sum.func(10));
		System.out.println("sum = " + sum.func(100));

	}

}
