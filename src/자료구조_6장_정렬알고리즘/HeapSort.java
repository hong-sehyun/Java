//홍세현 과제 제출 합니다
package 자료구조_6장_정렬알고리즘;

//heap 자료구조 1.0.doc 파일을 먼저 공부할 필요 
import java.util.Scanner;

//class Element {
//	public int key;
//
//	public int getElement() {
//		return key;
//	}
//
//	public Element(int key) {
//		this.key = key;
//	}
//}

interface MaxPQ {
	public void Insert(int x);

	public int DeleteMax(int x);
}

class MaxHeap implements MaxPQ {
	final int heapSize = 1000;

	public MaxHeap(int sz) {
		MaxSize = sz;
		n = 0;
		heap = new int[MaxSize + 1]; // Don't want to use heap[0]
	}

	public void display() {
		int i;
		for (i = 1; i <= n; i++)
			System.out.print("  (" + i + ", " + heap[i] + ") ");
		System.out.println();
	}

	public void Insert(int x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		for (i = n; i >= 1;) {
			if (i == 1)
				break; // at root
			if (x <= heap[i / 2])
				break;// 자바에서 generic array 사용 안됨
			// move from parent to i					
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = x;

	}

	@Override
	public int DeleteMax(int x) {

		int i, j;
		if (n == 0) {
			HeapEmpty();
			return 0;
		}
		x = heap[1];
		int k = heap[n];
		n--;

		for (i = 1, j = 2; j <= n;) {
			if (j < n)
				if (heap[j] < heap[j + 1])
					j++;
			// j points to the larger child
			if (k >= heap[j])
				break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return x;
	}

	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}

}

public class HeapSort {

	public static void main(String[] args) {
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		MaxHeap heap = new MaxHeap(200);
		int ele = 0;
		 final int count = 100;
	     int[] x = new int[count];

//		int[] x;
		
		int deletedEle = 0;

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 delete,  4 sort, 5 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
			     for (int i = 0; i < x.length; i++) {
			         x[i] = (int)(Math.random() * 30);
						heap.Insert(x[i]);
			     }
				break;
			case 2:
				heap.display();
				break;
			case 3:
				deletedEle = heap.DeleteMax(ele);
				if (deletedEle != 0) {
					System.out.println("deleted element: " + deletedEle);
				}
				System.out.println("current max heap: ");
				heap.display();
				break;
			case 4:
				for (int j = 0; j < x.length; j++) {
					deletedEle = heap.DeleteMax(ele);
					x[j] = deletedEle;
				}
				for (int num: x)
					System.out.println(" " + num);
			case 5:
				return;

			}
		} while (select < 5);

		return;		
	}
}
