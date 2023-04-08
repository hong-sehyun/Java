package chapter4;

public class Mission2_3 {

	
		private int[][] A = { {1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12} };
		
//		private int[][] B = { {13, 14, 15},
//				{16, 17, 18},
//				{19, 20, 21},
//				{22, 23, 24}};
		
		public void matrix() {
			for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
			
		}
		
				
//		for(int i = 0; i < A.length; i++) {
//			for(int j = 0; j < B[j].length; j++) {
//				int sum = 0;
//				for(int k = 0; k < A[i].length; k++) {
//					sum += (A[i][k] * B[k][j]);
//					
//				}
//				System.out.print(sum+"\t");
//			}
//			System.out.println();
//		}


}
//행렬 출력하기

//for(int i = 0; i < A.length; i++) {
//	for(int j = 0; j < A[i].length; j++) {
//		System.out.print(A[i][j]);
//		System.out.print("\t");
//	}
//	System.out.println("\n");
//}
