package chapter7.abstraction;

public class IPhoneMessenger implements Messenger {
	
	public String getMessage() {
		return "iPhone";
	}
	
	public void setMessage(String msg) {
		System.out.println("iPhone에서 메시지를 설정합니다 : " + msg);		
	}
	
	public void clearmessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
	}
	

}