package 자료구조_2장_기본자료구조;

import java.util.Random;

public class 행렬 {

	static void getData(int[][] data) {
		Random rd = new Random(99);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = rd.nextInt(10);
			}
		}
	}

	static void showData(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
	
	static int[][] A2(int[][] a, int[][] b) {
		/*
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		for (int k = 0; k < a.length; k++) {
			for (int l = 0; l < a[l].length; l++) {
				System.out.print(a[k][l]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		if(i == k && j == l) {
			System.out.println();
		}
		*/
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] += b[i][j];
			}
		}
		return a;
		
	}
	
	static int[][] C(int[][] a, int[][] b) {
		int[][] sum = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int k = 0; k < b[0].length; k++) {

				for (int j = 0; j < a.length; j++) {
					sum[i][k] += a[i][j]*b[j][k];
				}
			}
		} return sum;
	}

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] A1 = new int[2][3];
		int[][] B = new int[3][4];
//		int[][] C = new int[2][4];
		int[][] D = new int[3][2];
		System.out.println("A");
		getData(A);
		showData(A);
//		System.out.println("\nA1");
//		getData(A1);
//		showData(A1);
//		System.out.println("\nA2 = A + A1");
//		showData(A2(A,A1));

		
		System.out.println("\n====================");
		System.out.println("\nB");
		getData(B);
		showData(B);
		System.out.println("\nC");
//		getData(C(A,B));
		showData(C(A,B));
//		System.out.println("\nD");
//		getData(D);
//		showData(D);
		
	}

}
