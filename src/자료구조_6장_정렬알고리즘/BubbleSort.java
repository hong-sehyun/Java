package 자료구조_6장_정렬알고리즘;

import java.util.Random;

//버블 정렬(단순 교환 정렬) (버전 1)


class BubbleSort {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
 }

 //--- 버블 정렬 ---//
 static void bubbleSort(int[] a, int n) {
	 int count = 0;
	 int k= 0;
	 while (k < n-1) {
		 int last = n-1;
		 for (int j = n-1; j> k ; j--) {
			 count++;
			 if (a[j-1] > a[j]) {
				 swap(a, j-1, j);
				 last = j;
			 }			
		 }
		 k = last;
	 }
	 /*
     for (int i = 0; i < n - 1; i++) {
    	 int exchg = 0;     
         for (int j = n - 1; j > i; j--) {
        	 count++;
             if (a[j - 1] > a[j]) {
                 swap(a, j - 1, j);
                 exchg++;
             }
         }
         if(exchg == 0) break; 
        
     } */
     System.out.println("비교횟수 : " +count);
 }

 public static void main(String[] args) {

     Random random = new Random();
     System.out.println("버블 정렬(버전 1)");
     System.out.print("요솟수: ");
     int nx = random.nextInt(100);
     int[] x = new int[nx];

     for (int i = 0; i < nx; i++) {
        
         x[i] = random.nextInt(100);
         System.out.print("x[" + i + "]: " + x[i] + "/  ");
     }

     bubbleSort(x, nx);                // 배열 x를 단순교환정렬

     System.out.println("오름차순으로 정렬했습니다.");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
