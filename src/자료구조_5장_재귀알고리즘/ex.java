package 자료구조_5장_재귀알고리즘;

public class ex {

	public static void main(String[] args) {
		int c = 10;
		int n = 10;
		System.out.println(++c);
		System.out.println(n++);

		int row = 4, col = 4;
		int[][] data = new int[row][col];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				data[i][j] = 0;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
	

}
