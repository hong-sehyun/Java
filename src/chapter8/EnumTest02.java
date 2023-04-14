package chapter8;

enum Mandarin {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);
	private int price;
	
	Mandarin(int p) {
		price = p;
	}

	int getPrice() {
		return price;
	}
}

public class EnumTest02 {
public static void main(String[] args) {
	Object o1 = Mandarin.금귤;
	o1.hashCode();
	//o1.toString();
	//hashcode가 뭔지 궁금할땐 sysout으로
	System.out.println("hashCode : " + o1.hashCode());
	//hash 잘게 썬다는 뜻
	//자바에서 모든 만들어진 객체는 유니크한 식별자를 사용한다.
	
	//System.out.println("toString : " + o1.toString());
	
	Mandarin ma = Mandarin.한라봉;
	System.out.println(ma.name());
	System.out.println(ma.ordinal());
	
	if(ma == Mandarin.한라봉) {
		System.out.println("ma 는 한라봉");
	}
	System.out.println(ma + "가격 : " + ma.getPrice());
	
	Mandarin list[] = Mandarin.values();
	System.out.println("==귤의 종류==");
	for(Mandarin m : list) {
		System.out.println(m + " : " + m.getPrice());
	}
}
}
