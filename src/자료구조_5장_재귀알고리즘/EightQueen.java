package 자료구조_5장_재귀알고리즘;


//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking

class Point1 {
	
	private int x;
	private int y;

	public Point1(int x, int y) {
		this.x = x;
		this.y = y;		
	}
	

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	@Override
	public boolean equals(Object p) {
		Point1 px = (Point1) p;
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

class Stack3 {
	private int capacity; 
	private Point1 [] data;
	int top;
	
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

	public class EmptyGenericStackException extends RuntimeException {
		public EmptyGenericStackException() {
		}
	}
	
	public Stack3(int maxlen) {
		top=0;
		capacity = maxlen;
		try {
			data = new Point1[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public Point1 push(Point1 x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		return data[top++] = x;
	}

	public Point1 pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		{
			Point1 p = data[--top]; //top-1이 아닌 --top을 해야됨
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


public class EightQueen {
	
	static final int numberQueens = 4;
	
	static void SolveQueen(int[][] d) {

		int count = 0;
		int ix = 0;
		int iy = 0;

		Stack3 s = new Stack3(100);
		Point1 p = new Point1(ix, iy);

		d[ix][iy] = 1;
		count++;
		s.push(p);

		while (ix < numberQueens) {
			int cy = 0;
			while (cy < numberQueens) {
				cy = nextMove(d, ix, cy);
				if (cy != -1) {
					Point1 px = new Point1(ix, cy);
					d[ix][cy] = 1;
					s.push(px);
					count++;
					break;
					
				} else {
					Point1 py = s.pop();
					ix = py.getX();
					cy = py.getY();
					d[ix][cy] = 0;
					count--;
					cy++;
				}
			}
			ix++;
			if (count == numberQueens) {
				break;
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
		// 배열 d에 d[cx][cy]의 sw 대각선에 배치 가능하냐?
		int cx = x, cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy--;
		}
		cx = x;
		cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {			
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy++;
		}
		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--
		int cx = x, cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx--;
			cy--;
		}
		cx = x;
		cy = y;
		while (cx >= 0 && cx < numberQueens && cy >= 0 && cy < numberQueens) {
			if (d[cx][cy] == 1)
				return false;
			cx++;
			cy++;
		}
		return true;
	}

	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		else return false;
	}

	public static int nextMove(int[][] d, int row, int col) {// 다음 row에 대하여 이동할 col을 조사
		while (col < numberQueens) {
			if (checkMove(d, row, col))
				return col;
			col++;
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


		SolveQueen(data);
		
		for (int i = 0; i < numberQueens; i++) {
			for (int j = 0; j < numberQueens; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
