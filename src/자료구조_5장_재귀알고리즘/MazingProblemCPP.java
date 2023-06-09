package 자료구조_5장_재귀알고리즘;

public class MazingProblemCPP {
//	생성자, while 루프

	class items {
		int x, y, dir;

		public items(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}
	};

//
//ostream& operator<<(ostream& os, items& item)
//{
//return os << item.x << "," << item.y << "," << item.dir;
//}
//
	class offsets {
		int a, b;

		public offsets(int a, int b) {
			this.a = a;
			this.b = b;
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
	};
//
//enum directions { N, NE, E, SE, S, SW, W, NW };
//offsets moves[8];

//int maze[100][100];
//int mark[100][100];
//

	public class 미로찾기 {
		static offsets[] moves = new offsets[8];
	}

	public static void path(int[][] maze, int[][] mark) {

	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		// 한번 갔던곳은 다시 갈 필요 없기 떄문에 마크배열 사용
		int[][] mark = new int[14][17];

//void path(int m, int p)
////Output a path (if any) in the maze; rows is m, cols is p;
//{
//	//start at (1,1)
//	mark[1][1] = 1;
//	Stack<items> stack(m * p);
//	items temp;
//	temp.x = 1; temp.y = 1; temp.dir = E;
//	stack.Push(temp);
//
//	while (!stack.IsEmpty()) // stack not empty
//	{
//		temp = stack.Pop(); // unstack
//		int i = temp.x; int j = temp.y; int d = temp.dir;
//		while (d < 8) // moves forward
//		{
//			//outFile << i << " " << j << " " << d << endl;
//			int g = i + moves[d].a;
//			int h = j + moves[d].b;
//			if ((g == m) && (h == p)) { // reached exit
//										// output path
//				cout << stack;
//
//				cout << "the term near the exit: " << i << " " << j << endl;
//				cout << "exit: " << m << " " << p << endl;
//				return;
//			}
//			if ((!maze[g][h]) && (!mark[g][h])) { // new position
//				mark[g][h] = 1;
//				//push the old temp to the stack, but the direction changes.
//				//Because the neighbor in the direction of d has been checked.
//				temp.x = i;  temp.y = j; temp.dir = d + 1;
//				stack.Push(temp); // stack it
//				i = g; j = h; d = N; // moves to (g,h)
//			}
//			else d++; // try next direction
//		}
//	}
//	cout << "no path in maze " << endl;
//}
///*
//maze[][], mark[][]를 class의 private data member로 선언
//main()에서는 class의 public function의 호출로 미로 찾기
//*/
//void main() {

		int input[][] = { // 12 x 15
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
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);
		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;

			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
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
