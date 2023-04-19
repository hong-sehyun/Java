package chapter11;
//예외 발생 및 처리
public class Test01 {

	public static void main(String[] args) {


		try {
			int arr[] = new int[3];
			arr[3] = 30;
			String s = "java";
			s = null;
			System.out.println(s.length());
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("에러발생");
			e.printStackTrace();
		} catch(NullPointerException e1) {
			e1.getMessage();
			e1.toString();
			System.out.println("null 에러발생" + e1);
		}
		
		//System.out.println("OK");
	}

}
