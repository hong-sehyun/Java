package 자료구조_5장_재귀알고리즘;
class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
		ix = x;
		iy = y;
	}

	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

class MyStack {
	private int top;
	Point2[] data;

	public MyStack() {
		top = 0;
		data = new Point2[1000];
	}

	public boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}

	public void push(Point2 p) {
		data[top++] = p;
	}

	public Point2 pop() {
		if (top <= 0) {
			System.out.println("-1");
		}
		return data[--top];
	}

}

public class Queen8 {
	static int r = 8;
	static int c = 8;
	static int[][] arr = new int[r][c];

	public static void nextMove(int[] move, int r) {

	}

	public static boolean checkMove(int x, int y) {
		if (!checkR(x))
			return false;
		if (!checkC(y))
			return false;
		if (!checkS(x, y))
			return false; // x++, y-- or x--, y++ / 0<=x, y<=7
		if (!checkBS(x, y))
			return false; // x++, y++ or x--, y--

		return true;
	}

	public static boolean checkR(int x) {
		for (int i = 0; i < r; i++) {
			if (arr[x][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkC(int y) {
		for (int i = 0; i < c; i++) {
			if (arr[i][y] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkS(int x, int y) {
		int ux = x;
		int uy = y;
		while (ux >= 0 && ux < r && uy >= 0 && uy < c) {
			if (arr[ux][uy] == 1)
				return false;
			ux++; uy--;
		}
		ux = x; uy = y;
		while (ux >= 0 && ux < r && uy >= 0 && uy < c) {
			if (arr[ux][uy] == 1)
				return false;
			ux--; uy++;
		}
		return true;
	}

	public static boolean checkBS(int x, int y) {
		int ux = x; int uy = y;
		while (ux >= 0 && ux < r && uy >= 0 && uy < c) {
			if (arr[ux][uy] == 1)
				return false;
			ux++; uy++;
		}
		ux = x; uy = y;
		while (ux >= 0 && ux < r && uy >= 0 && uy < c) {
			if (arr[ux][uy] == 1)
				return false;
			ux--; uy--;
		}
		return true;
	}

	public static void solveQueen() {
		Point2 p = new Point2(0, 0);
		MyStack s = new MyStack();
		int x = p.getX();
		int y = p.getY();
		int flag = 0;
		while (true) {
			while (x < r) {
				while (y < c) {
					if (checkMove(x, y)) {
						arr[x][y] = 1;
						s.push(new Point2(x, y));
						y = 0;
						break;
					}
					y++;
				}
				x++;
				if (y >= c) {
					if (!s.isEmpty()) {
						p = s.pop();
						x = p.getX();
						y = p.getY();
						arr[x][y] = 0;
						y++;
					} else {
						flag = 1;
						break;
					}
				}
			}
			if (flag == 1)
				break;

			board();

			p = s.pop();
			x = p.getX();
			y = p.getY();
			arr[x][y] = 0;
			y++;
		}
	}

	static int num = 0;

	public static void board() {
		System.out.println(++num + "번 째 clear");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		solveQueen();
	}
}