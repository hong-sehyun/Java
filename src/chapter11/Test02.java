package chapter11;

import java.io.FileInputStream;

public class Test02 {

	public static void main(String[] args) {

		
		try(FileInputStream fi = new FileInputStream("a.txt")) { 
			String s = null;
			s.length();
			
		} catch (Exception e) {
			
			System.out.println("error");
		} finally {
			//fi.close();
			System.out.println("OK");
		}
		
		System.out.println("4");
	}

}
