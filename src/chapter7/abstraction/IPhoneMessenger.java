package chapter7.abstraction;

public class IPhoneMessenger implements Messenger, WorkFile {
	
//	public class IPhoneMessenger extends GraphicIOS implements Messenger, WorkFile {	
//	private String msg;
	
	public String getMessage() {
		return "iPhone";
	}
	
	public void setMessage(String msg) {
		System.out.println("iPhone에서 메시지를 설정합니다 : " + msg);		
	}
	
	public void clearmessage() {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
	}
	
	public void fileUpload() {
		System.out.println("iPhone file을 업로드 합니다.");
	}
	
	public void downUpload() {
		System.out.println("iPhone file을 다운로드 합니다.");
	}
	
//	public String getMsg() {
//		return msg;
//	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
//

//	public void draw_textBox() {
//		System.out.println("텍스트 상자를 그린다");
//		super.draw_textBox();
//	}
//	public void draw_submittButton() {
//		System.out.println("GraphicIOS : 전송버튼을 그린다");
//		super.draw_submittButton();
//	}

}
