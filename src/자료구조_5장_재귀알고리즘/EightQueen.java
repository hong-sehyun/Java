package 자료구조_5장_재귀알고리즘;

	
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

class Stack3 {
	private int capacity; 
	private Point [] data;
	int top;
	
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}
	
	public Stack3(int maxlen) {
		top=0;
		capacity = maxlen;
		try {
			data = new Point[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public Point push(Point x) throws OverflowIntStackException {
		if (top >= capacity)
			throw new OverflowIntStackException();
		return data[top++] = x;
	}

	public Point pop() throws EmptyIntStackException {
		if (top <= 0)
			throw new EmptyIntStackException();
		{
			Point p = data[--top]; //top-1이 아닌 --top을 해야됨
			return p;
		}
	}
	
	public boolean isEmpty() {
		return top <= 0;
	}
	
	public void dump() {

		if (isEmpty())
			// if (ptr <= 0)
			System.out.println("stack이 비었다");
		else {
			for (int i = 0; i < top; i++)
				System.out.println(data[i] + " ");
			System.out.println();
		}
	}
}

class Point {
	
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;		
	}

	@Override
	public boolean equals(Object p) {
		Point px = (Point) p;
		if (this.x == px.x && this.y == px.y)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y ;
	}	
}

public class EightQueen {
	
	static final int numberQueens = 4;
	
	public static void SolveQueen(int[][] d) {
		int count = 0;
		int ix = 0, iy = 0;
		Stack3 st = new Stack3(100);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);
		while (count < numberQueens) {
			ix++;
			int cy = 0;  //그 다음줄은 처음부터 다 뒤져봐야되기 떄문에 0부터 시작

			while (cy != -1) {
				cy = nextMove(d, ix, cy);
				System.out.println("x:" + ix + " y: " + cy +"");
				while (cy != -1) {
					Point px = new Point(ix, cy);

					
					st.push(px);
					d[ix][iy] = 1;
					
					count++;
					st.dump();
					break;
				}
				if (cy != numberQueens) {
					break;
				} else {
					p = st.pop();
					count--;
				}
				System.out.println("count:"+count);
			}
		}
	}

	public static boolean checkRow(int[][] d, int crow) {
		//배열 d에서 crow에 Queen 을 놓을 수 있느냐?
		for(int i = 0; i < numberQueens; i++) 
			if (d[crow][i] == 1) return false;
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		for(int i = 0; i < numberQueens; i++) 
			if (d[i][ccol] == 1) return false;
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		//배열 d에 d[cx][cy]의 sw 대각선에 배치 가능하냐?
		int cx = x, cy = y;
		while(true) {
			cx++; cy--;
			if (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens)
				if (d[cx][cy] == 1) return false;
				else break;
		}
		cx = x; cy = y;
		while(true) {
			cx--; cy++;
			if (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens)
				if (d[cx][cy] == 1) return false;
				else break;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--
		int cx = x, cy = y;
		while(true) {
			cx--; cy--;
			if (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens)
				if (d[cx][cy] == 1) return false;
				else break;
		}
		cx = x; cy = y;
		while(true) {
			cx++; cy++;
			if (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens)
				if (d[cx][cy] == 1) return false;
				else break;
		}
		return true;
	}

	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y) == true)
			return true;
		else return false;
	}

	public static int nextMove(int[][] d, int row, int col) {// 다음 row에 대하여 이동할 col을 조사
		for(int i = 0; i< numberQueens; i++) {
			if (checkMove(d, row, i) == true) 
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int row = numberQueens, col = numberQueens;
		int[][] data = new int[row][col];
		for (int i = 0; i < numberQueens; i++) {
			for (int j = 0; j < numberQueens; j++)
				data[i][j] = 0;
		}


//		SolveQueen(data);
//		checkRow(data, row);
//		checkCol(data, col);
//		checkDiagSW(data, row, col);
//		checkDiagSE(data, row, col);
//		checkMove(data, row, col);
//		nextMove(data, row, col);
		SolveQueen(data);
		
		for (int i = 0; i < numberQueens; i++) {
			for (int j = 0; j < numberQueens; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
