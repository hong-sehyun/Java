package chapter3;

import java.util.Scanner;

public class Mission1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("국영수 세 과목의 점수를 입력하세요 : ");
		int Korean = sc.nextInt();
		int English = sc.nextInt();
		int Math = sc.nextInt();
		
		int sum = Korean + English + Math;
		double avrg = sum/3;
		double avrg2 = Double.parseDouble(String.format("%.2f",avrg)); 
	
		if(avrg2 >= 70 && Korean >= 60 && English >= 60 && Math >= 60) {
			System.out.println("입력 : " + Korean + "," + English + "," + Math + "," + " 총계 : " + sum + "," + " 평균 : " + avrg2 + " → " + "통과" );
		}
		else {
			System.out.println("입력 : " + Korean + "," + English + "," + Math + "," + " 총계 : " + sum + "," + " 평균 : " + avrg2 + " → " + "과락" );
		}

		sc.close();
		
	}

}
