package chapter8.innerClass;
interface Messenger {
	String getMessage();
	void setMessage(String msg);
	
	//인터페이스에는 함수 선언만 있고 함수 바디는 없다
}

//class GMessenger implements Messenger {
//	public String getMessage() {
//		return "Good";
//	}
//	public void setMessage(String msg) {
//		System.out.println("my data = "+msg);
//	}
//	
//	public void changeMode() {
//		System.out.println("changed");
//	}
//
//}
public class 익명클래스 {
	public static void main(String[] args) {
//		GMessenger gm = new GMessenger();
		Messenger gm = new Messenger() {
			public String getMessage() {
				return "Good";
			}
			public void setMessage(String msg) {
				System.out.println("my data = "+msg);
			}
	
			public void changeMode() {
				System.out.println("changed");
			}
		};
		
		gm.getMessage();
		gm.setMessage("hong");
	}

}
