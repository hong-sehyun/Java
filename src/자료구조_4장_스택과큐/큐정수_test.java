package 자료구조_4장_스택과큐;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//int형 고정 길이 큐

class Queue {
	private List<Integer> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수
	
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowQueueException  () { }
	}

	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException () {	}
	}
	
	public Queue (int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int size () {
		return num;
	}
	public int getCapacity() {
		return capacity;
	}
	
	public int enque (int x) throws OverflowIntQueueException {
		if (num >= capacity) throws new OverflowIntQueueException ();
		que[rear++] = x;
		num++;
	}
}


//int형 고정 길이 큐의 사용 예
public class 큐정수_test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue s = new Queue(4); // 최대 64개를 인큐할 수 있는 큐

		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				x = sc.nextInt();
				try {
					s.enque(x);
				} catch (Queue.OverflowQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (Queue.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (Queue.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
