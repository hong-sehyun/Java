package 자료구조_5장_재귀알고리즘;

import java.util.Scanner;

class IntStack {

	private int[] stk; // 스특을 배역
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}

	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}

	public IntStack (int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
		
		public int push(int x) throws OverflowIntStackException {
			if (ptr >= capacity)
				throw new OverflowIntStackException();
			return stk[ptr++] = x;
		}
		public int pop() throws OverflowIntStackException {
			if (ptr <= 0)
				throw new OverflowIntStackException();
			return stk[--ptr];
		}
		public int peek() throws OverflowIntStackException {
			if (ptr <= 0)
				throw new OverflowIntStackException();
			return stk[ptr-1];
		}
		
		public void clear() {
			ptr = 0;
		}
		
		public int IndexOf(int x) {
			for (int i = ptr -1; i >=0; i--) 
				if (stk[i]==x) return i;
				return -1;
		}
		
	    public int getCapacity() {
	        return capacity;
	    }
		
	    public int size() {
	        return ptr;
	    }
		
		public boolean isEmpty () {
			return ptr <= 0;
		}
		
		public void dump() {
			
			if (isEmpty())
			//if (ptr <= 0) 
				System.out.println("stack이 비었다");
			else {
				for (int i = 0; i <ptr; i++) 
					System.out.println(stk[i] +" ");
				System.out.println();
			}
		}
	}


public class 스택정수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);    // 최대 64 개를 푸시할 수 있는 스택

        while (true) {
        	System.out.println(); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(0)종료: ");

            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
             case 1:                                // 푸시
                System.out.print("데이터: ");
                x = sc.nextInt();
                try {
                    s.push(x);
                 } catch (IntStack.OverflowIntStackException e) {
                    System.out.println("스택이 가득 찼습니다.");
                }
                break;

             case 2:                                // 팝
                try {
                     x = s.pop();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                 } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비어있습니다.");
                }
                break;

             case 3:                                // 피크
                try {
                     x = s.peek();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                 } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비어있습니다.");
                }
                break;

             case 4:                                // 덤프
                s.dump();
                break;
            }
        }

	}
}
