package 자료구조_5장_재귀알고리즘;

import java.util.Stack;

class MazeCell {
	int i;
	int j;
	int dir;

	public MazeCell(int _i, int _j, int _dir) {
		i = _i;
		j = _j;
		dir = _dir;
	}

	public String toString() {
		return "<" + i + "," + j + ">";
	}
}

public class MazePath {
	private int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1 }, // 1
			{ 1, 0, 1, 1, 0, 1, 1, 1 }, // 2
			{ 1, 0, 0, 1, 0, 1, 1, 1 }, // 3
			{ 1, 1, 0, 0, 0, 1, 1, 1 }, // 4
			{ 1, 1, 1, 0, 0, 0, 1, 1 }, // 5
			{ 1, 0, 0, 0, 1, 1, 1, 1 }, // 6
			{ 1, 1, 0, 1, 0, 0, 0, 1 }, // 7
			{ 1, 0, 0, 0, 0, 1, 0, 0 }, // 8
			{ 1, 1, 1, 1, 1, 1, 1, 1 } // 9
	};
	private int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북 동 남 서
	private int m = maze.length - 2;
	private int n = maze[0].length - 1;

	public MazePath() { // 알고리즘대로 프로그램 작성
		int mark[][] = new int[maze.length][maze[0].length];
		Stack st = new Stack();
		Stack st1 = new Stack(); // 올바른 경로 삽입할 스택
		st.push(new MazeCell(1, 1, 1)); // 초기출발위치? 방향 설정
		while (st.isEmpty() != true) {
			MazeCell mc = (MazeCell) st.pop(); // 지나온 경로를 pop함
			while (mc.dir <= 3) {
				int nextI = mc.i + move[mc.dir][0]; // 갈려고하는 방향으로 i+
				int nextJ = mc.j + move[mc.dir][1]; // 갈려고하는 방향으로 j+

				if (nextI == m && nextJ == n) { // 미로경로 발견
					System.out.println("경로를 발견했습니다");
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); // 마지막 경로 지정
					st.push(new MazeCell(nextI, nextJ, 0)); // 마지막 지점 지정
					while (st.isEmpty() != true) {
						st1.push((MazeCell) st.pop());
						mc = (MazeCell) st1.pop(); // 올바른 경로 출력
						System.out.println(mc);
						maze[mc.i][mc.j] = 2;
					}
				
					displayMaze(); // 경로 확인 완료후 출력
					return;
				}
				if (maze[nextI][nextJ] == 0 && mark[nextI][nextJ] == 0) {// 이동가능&시도해보지 않은위치
					mark[nextI][nextJ] = 1;
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); // 지나온경로를 스택에 push
//mc = new MazeCell(nextI,nextJ,0); //새로운 위치와 방향 설정 방향은 초기화
					mc.i = nextI;
					mc.j = nextJ;
					mc.dir = 0;
				} else {
					mc.dir++;
				}
			}
		}
		System.out.println("경로를 발견하지 못했습니다");

	}

	public void displayMaze() {
		String[] str = { "□", "■", "☞" };
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(str[(maze[i][j])]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		new MazePath();
	}
}