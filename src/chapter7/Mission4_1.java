package chapter7;

public class Mission4_1 {

	static int evensum;
	static int oddsum;
	static int sum;

	public int getEvensum() {
		return evensum;
	}

	public void setEvensum(int evensum) {
		this.evensum = evensum;
	}

	public int getOddsum() {
		return oddsum;
	}

	public void setOddsum(int oddsum) {
		this.oddsum = oddsum;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public static void sum1() {
		for (int i = 1; i < 1000; i++) {
			sum += i;
			if (i % 2 == 0) evensum += i;
			else oddsum += i;
		}
		System.out.println(sum);
		System.out.println(evensum);
		System.out.println(oddsum);
	}
	

	@Override
	public String toString() {
		return "Mission4_1 [evensum=" + evensum + ", oddsum=" + oddsum + ", sum=" + sum + "]";
	}

	public static void main(String[] args) {
		Mission4_1 m = new Mission4_1();
		m.sum1();
		System.out.println(m);
	}

}
