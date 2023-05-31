package 자료구조_6장_정렬알고리즘;

import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);

	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 10;

	public Heap(int sz) {

	}

	public void display() {

	}
	@Override
	public void Insert(int x) {


	}
	@Override
	public int DeleteMax() {

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
public class heap정렬 {
	
	public static void main(String[] args) {
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 100;
	    int[] x = new int[count+1];
	    int []sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
			     for (int i = 0; i < count; i++) {
			         x[i] = (int)(Math.random() * 130);
						heap.Insert(x[i]);
			     }
				break;
			case 2:
				heap.display();
				break;
			case 3:
				for (int i = 1; i <= count; i++)
					sorted[i-1] = heap.DeleteMax();
				for(int num: sorted)
					System.out.print(" " + num);
				System.out.println();
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}

