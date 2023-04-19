package chapter10;
//HashMap
import java.util.HashMap;
import java.util.Iterator;

public class Test06 {

	public static void main(String[] args) {
		String word[] = { "BEE", "Haven", "ALL", "WONDER" };
		String meaning[] = { "꿀벌", "천국", "모든", "경이" };

		HashMap<String, String> dic = new HashMap<String, String>();

		for (int i = 0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		System.out.println(dic.toString());
		System.out.println(dic.keySet());
		System.out.println(dic.values());

//p509 방법1 2 3 숙달훈련 필요!!

		Iterator<String> keys = dic.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(dic.get(key));
		}
	}

}
