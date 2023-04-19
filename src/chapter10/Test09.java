package chapter10;
//TreeMap
import java.util.Map;
import java.util.TreeMap;

public class Test09 {
	
	public static void main(String[] args) {
		TreeMap<String, String> users = new TreeMap<String, String>();
		
		
		users.put("12", "홍길동");
		users.put("22", "홍길동");
		users.put("52", "홍길동");
		users.put("15", "홍길동");

		System.out.println(" " + users.toString());
	
		Map.Entry<String, String> entry = null;
		entry = users.firstEntry();
		System.out.println(entry);
	
	
	}

}
