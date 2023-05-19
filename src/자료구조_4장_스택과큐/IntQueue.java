package 자료구조_4장_스택과큐;



public class IntQueue {
	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;
	
//	public class EmptyIntQueueException extends RuntimeException {
//		public EmptyIntQueueException() { }
//	}
//	
//	public class OverflowIntQueueException extends RuntimeException {
//		public OverflowIntQueueException() { }
//	}
	
	public IntQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
}

//
//public int peek() throws EmptyIntQueueException {
//	
//}
