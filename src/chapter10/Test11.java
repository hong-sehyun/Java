package chapter10;
//객체 비교
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class User {
	String ssn;
	String name;
	public User(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [ssn=" + ssn + ", name=" + name + "]";
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(ssn);
//	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(ssn, other.ssn);
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if(this.ssn.equals(obj.ssn))
//			return true;
//		else return false;
//	}

	
}

public class Test11 {

	public static void main(String[] args) {


		User u1 = new User("123", "홍길동");
		User u2 = new User("123", "홍길순");
		HashSet<User> users = new HashSet<>();
		if(u1.equals(u2)) users.add(u2);
		else users.add(u1);
		
		//users.add(u1);
		//users.add(u2);
		
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {

			System.out.println(iter.next().toString());

			
		}
	}

}
