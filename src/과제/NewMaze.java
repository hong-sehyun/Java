package 과제;

import java.util.ArrayList;
import java.util.List;

class Items {
    int x;
    int y;
    int dir;

    public Items(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public boolean equals(Object p) {
        Items px = (Items) p;
        return this.x == px.x && this.y == px.y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}

class Offsets {
    int a;
    int b;

    public Offsets(int ia, int ib) {
        a = ia;
        b = ib;
    }
}

class StackList {
    private List<Items> data;
    private int capacity;
    private int top;

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
        data = new ArrayList<Items>(capacity);
    }

    public int push(Items x) throws OverflowGenericStackException {
        if (top >= capacity)
            throw new OverflowGenericStackException();
        data.add(x);
        top++;
        return 1;
    }

    public Items pop() throws EmptyGenericStackException {
        if (top <= 0)
            throw new EmptyGenericStackException();
        top--;
        return data.remove(top);
    }

    public Items peek() throws OverflowGenericStackException {
        if (top <= 0)
            throw new OverflowGenericStackException();
        return data.get(top - 1);
    }

    public void clear() {
        top = 0;
    }

    public int indexOf(Items x) {
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
            System.out.println("Stack is empty");
        else {
            for (int i = 0; i < top; i++)
                System.out.println(data.get(i) + " ");
            System.out.println();
        }
    }
}

public class NewMaze {
    enum Directions {N, NE, E, SE, S, SW, W, NW}

    static Offsets[] moves = new Offsets[8];

    public static void path(int[][] maze, int[][] mark, int ix, int iy) {
        mark[1][1] = 1;
        StackList st = new StackList(50);
        Items temp = new Items(0, 0, 0);
        temp.x = 1;
        temp.y = 1;
        temp.dir = 2;
        mark[temp.x][temp.y] = 2;
        st.push(temp);

        while (!st.isEmpty()) {
            Items tmp = st.pop();
            int i = tmp.x;
            int j = tmp.y;
            int d = tmp.dir;
            mark[i][j] = 1;

            while (d < 8) {
                int g = i + moves[d].a;
                int h = j + moves[d].b;

                if (g == ix && h == iy) {
                    temp.x = i;
                    temp.y = j;
                    temp.dir = d + 1;
                    st.push(temp);
                    temp.x = g;
                    temp.y = h;
                    temp.dir = 0;
                    st.push(temp);
                    st.dump();
                    mark[i][j] = 0;
                    d = d + 1;
                } if ((maze[g][h] == 0) && (mark[g][h] == 0)) {
                    mark[g][h] = 2;
                    temp.x = i;
                    temp.y = j;
                    temp.dir = 0;
                    st.push(temp);
                    i = g;
                    j = h;
                    d = 0;
                } else
                    d = d + 1;
            }
        }
        System.out.println("No path in the maze.");
    }

    public static void main(String[] args) {
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

        int[][] mark = new int[12][15];
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
        path(maze, mark, 12, 15);
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
