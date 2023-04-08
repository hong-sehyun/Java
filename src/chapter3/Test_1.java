package chapter3;

import java.util.Scanner;

public class Test_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적을 입력하세요");
		int score = sc.nextInt();
		char grade;
		
		if(score > 100 || score < 0) {
			System.out.println("부적절한 점수 입니다."); 
		    return;
		    
		}
		
		
		else if(score >= 90) grade = 'A';
		
		else if(score >= 80) grade = 'B';
		
		else if(score >= 70) grade = 'C';
		
		else if(score >= 60) grade = 'D';
		
		else grade = 'F';
		
		System.out.println("당신의 성적은 " + grade + " 입니다.");
		
		
		sc.close();
	}

}