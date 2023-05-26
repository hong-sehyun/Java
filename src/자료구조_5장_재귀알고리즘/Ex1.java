package 자료구조_5장_재귀알고리즘;

import java.util.Random;
import java.util.Scanner;


class Stack1 {
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
	
	public Stack1(int maxlen) {
		top=0;
		capacity = maxlen;
		try {
			data = new Point[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public Point push1(Point x) throws OverflowIntStackException {
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
class Point1 {
	private int x;
	private int y;

	public Point1(int x, int y) {
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
public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex1 e = new Ex1();
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
//			System.out.printf("현재 데이터 개수: %d / %d\n", e.size(), e.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				rndx = random.nextInt(20)  ;
				rndy = random.nextInt(30) ;
//				rndx = (int) (Math.random()*100);
//				rndy = (int) (Math.random()*100);
				p = new Point(rndx, rndy);
				try {
					e.push1(p);
				} catch (Ex1.OverflowIntStackException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = e.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch (Ex1.EmptyIntStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = e.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (Ex1.EmptyIntStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				e.dump();
				break;
			}
		}
		sc.close();
	}


}
