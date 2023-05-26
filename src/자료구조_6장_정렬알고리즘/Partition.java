package 자료구조_6장_정렬알고리즘;

import java.util.Random;

//배열을 나눔

import java.util.Scanner;

class Partition {

 //--- 배열 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 배열을 나눔 ---//
 static int count = 0;
 static void quickSort(int[] a, int left, int right) {
     int pl = left;        // 왼쪽 커서
     int pr = right;    // 오른쪽 커서
     int x = a[(pl +pr)/2];  // 피벗(가운데 요소)

     do {
         while (a[pl] < x) {
        	 pl++;
        	 count++;
         }
         while (a[pr] > x) {
        	 pr--;
        	 count++;
         }
         if (pl <= pr) {
        	 swap(a, pl++, pr--);
        	 count++;
         }
             
     } while (pl <= pr); {
     if(left < pr) quickSort(a, left, pr);
     if (pl < right) quickSort(a, pl , right); }
     System.out.println();
     System.out.println("피벗의 값은 " + x + "입니다.");

//     System.out.println("피벗 이하 그룹 ");
//     for (int i = 0; i <= pl - 1; i++)              // a[0] ～ a[pl - 1]
//         System.out.print(a[i] + " ");
//     System.out.println();
//
//     if (pl > pr + 1) {
//         System.out.println("피벗과 일치하는 그룹 ");
//         for (int i = pr + 1; i <= pl - 1; i++)    // a[pr + 1] ～ a[pl - 1]
//             System.out.print(a[i] + " ");
//         System.out.println();
//     }
//
//     System.out.println("피벗 이상 그룹 ");
//     for (int i = pr + 1; i < n; i++)              // a[pr + 1] ～ a[n - 1]
//         System.out.print(a[i] + " ");
//     System.out.println();
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);
     Random random = new Random();
     System.out.println("배열을 나눕니다.");
     int [] x = {5, 7, 1, 4, 6, 2, 3, 9, 8};
     int nx=9;


     for (int i = 0; i < nx; i++) {
         System.out.print("x[" + i + "]: " + x[i] + " ");

     }
//     partition(x, nx);                // 배열 x를 나눔
     quickSort(a, right, left);
 }
}
