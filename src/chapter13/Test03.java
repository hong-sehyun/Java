package chapter13;
class Solid{}
class Liquid{}

class Book extends Solid{}
class Pencile extends Solid{}
class Note extends Solid{}
class Water extends Liquid{}
class coffee extends Liquid{}
class Bag<T extends Solid> {
	T thing;
	String owner;
	public Bag(T thing) {
		thing = thing;
	}
	public T getThing() {return thing;}
	String getOwner() {
		return owner;
	}
	boolean IsSameOwner(Bag<?> obj) {
		if(this.owner.equals(obj.getOwner()))
			return true;
		return false;
	}
}

public class Test03 {
public static void main(String[] args) {
	Bag<Book> bag = new Bag<>(new Book());
	Bag<Pencile> bag2 = new Bag<>(new Pencile());
	bag = bag2;
	bag.IsSameOwner(bag2);

	//Bag<Water> water = new Bag<>(new Water());
	
}
}
