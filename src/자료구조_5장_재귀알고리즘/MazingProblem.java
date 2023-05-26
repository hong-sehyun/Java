package 자료구조_5장_재귀알고리즘;

import java.util.ArrayList;
import java.util.List;


class Items {
//  Items: 위치와 이동경로를 한 번에 저장하는 구조체 

	int x;		//	x, y : 이동 경로 상에서 위치(행과 열)
	int y;
	int dir;    //	dir : 다음에 이동한 방향 
	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	@Override
	public boolean equals(Object p) {
		Items px = (Items) p;
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
class Offsets {
	//offset : 이동 방향 8개를 간단히 저장하기 위한 구조체 (북쪽 방향부터 시계방향으로 8개 방향)
	int a;
	int b;
	
	public Offsets(int ia, int ib) {
		a = ia;
		b = ib;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	


}

class StackList {
	private List<Items> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

	public class EmptyGenericStackException extends RuntimeException {
		public EmptyGenericStackException() {
		}
	}

	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Items>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(Items x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		{
			top++;
			data.add(x);
			return 1;
		}
	}

	public Items pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		{
			Items p = data.remove(--top); // top-1이 아닌 --top을 해야됨
			return p;
		}
	}

	public Items peek() throws OverflowGenericStackException {
		if (top <= 0)
			throw new OverflowGenericStackException();
		return data.get(top - 1);
	}

	public void clear() {
		top = 0;
	}

	public int IndexOf(int x) {
		for (int i = top - 1; i >= 0; i--)
			if (data.get(i).equals(x))
				return i;
		return -1;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	public void dump() {

		if (isEmpty())
			System.out.println("stack이 비었다");
		else {
			for (int i = 0; i < top; i++)
				System.out.println(data.get(i) + " ");
			System.out.println();
		}
	}
}
public class MazingProblem {
	
	enum Directions {N, NE, E, SE, S, SW, W, NW}
	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다

	//mark : 방문 여부를 기록할 array (maze와 크기가 같게 만든다.)
	//maze : 미로의 경계선까지 포함한 미로의 구조
	public static void path(int[][] maze, int[][] mark, int ix, int iy) {
//		int[][] mark = new int[ix][iy];
//		int[][] maze = new int[ix][iy];
		mark[1][1] = 1;
		StackList st = new StackList(50);
//		StackList st1 = new StackList(50);
		Items temp = new Items(0, 0, 0);//N :: 0
		temp.x = 1;
		temp.y = 1;
		temp.dir = 2;//E:: 2
		mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시
		st.push(temp);

		
		
		
		while (!st.isEmpty()) // stack not empty
		{
			Items tmp = st.pop(); // unstack
			int i = tmp.x;
			int j = tmp.y;
			int d = tmp.dir;
			mark[i][j] = 1;//backtracking 궤적은 1로 표시
			while (d < 8) // moves forward
			{	//동쪽으로 이동
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				
				if ((g == ix) && (h == iy)) { // reached exit
					// output path
					Items newtmp = new Items(g, h, 0);					
					st.push(newtmp);
					maze[g][h] = 2;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
//					mark[g][h] = 1;
					st.push(tmp); //경로를 스택에 저장
					i = g;
					j = h;
					d = 0;
				} else {
					d++;
				}
				
			}
		}
		System.out.println("no path in maze ");
	}
	
//	=======================


	public static void main(String[] args) {
//		int[][] maze = new int[14][17];
		int[][] mark = new int[12][15];

		int maze[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int ia = 0; ia < 8; ia++) 
			moves[ia] = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
		//a는 행, b는 열
		//moves[0]은 enum의 값 ex)moves[0]은 N방향으로 움직이는것.
		moves[0].a = -1;	moves[0].b = 0;
		moves[1].a = -1;	moves[1].b = 1;
		moves[2].a = 0;		moves[2].b = 1;
		moves[3].a = 1;		moves[3].b = 1;
		moves[4].a = 1;		moves[4].b = 0;
		moves[5].a = 1;		moves[5].b = -1;
		moves[6].a = 0;		moves[6].b = -1;
		moves[7].a = -1;	moves[7].b = -1;
		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
//		for (int i = 0; i < 14; i++) {
//			for (int j = 0; j < 17; j++) {
//		
//
//			}
//		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}
		
		System.out.println("mark::");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}
		path(maze, mark, 12, 15);

		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
