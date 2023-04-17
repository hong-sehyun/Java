package chapter7.abstraction;

public class MessengerTest {
	
	public static void main(String[] args) {
		
		
		IPhoneMessenger iPhone = new IPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		
		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);

		iPhone.setLogin(true);
		iPhone.getMessage();
		iPhone.setMessage("hello");
		iPhone.clearmessage();
//		iPhone.draw_textBox();
//		iPhone.draw_submittButton();
		iPhone.fileUpload();
		iPhone.downUpload();
//		iPhone.getMsg();
		
		//오류 - page324 참조
		
		System.out.print("\n");
		
		galaxy.setLogin(true);
		galaxy.getMessage();
		galaxy.setMessage("hi");
		galaxy.changeKeyboard();
		galaxy.fileUpload();
		galaxy.downUpload();
	}

}
