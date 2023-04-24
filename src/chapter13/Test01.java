package chapter13;
class Book {	
	String name;
}
class Pencile {
	String name;
}
/*
class Bag{
	Book book;
	Pencile pencile;
}
*/
class Bag <T>{
	T item;
	public Bag(T thing) {
		item = thing;
	}

public T getThing() {
	return item;
}
}
public class Test01 {
	public static void main(String[] args) {
//		Bag b = new Bag<>();
		Bag<Book> b = new Bag<Book>(new Book());
		Bag<Pencile> p = new Bag<Pencile>(new Pencile());
		Book book = b.getThing();
		
	}

}
