package chapter8.innerClass;

class Node {
	String data;
	Node link;

	Node(String data) {
		this.data = data;
		link = null;
	}

	public String toString() {
		return "data" + data;
	}
}

class LinkedList {
	Node head;

	void show() {
		Node p = head;
/*		While(p != null) {
			System.out.println(p.toString());
			p = p.link;
		} */
		p = p.link;

	}

	void add(String name) {
		Node temp = new Node(name);
		if (head == null) {
			head = temp;
		} else {
			temp.link = head;
			head = temp;
		}
	}
}

public class ListClass {
	public static void main(String[] args) {
		LinkedList my = new LinkedList(); // 타입 설정x Object로 입력
		my.add("hong");
		my.add("kim");
		my.add("lee");
		my.add("park");
		my.add("choi");
	}
}

//처음부터 노드를 만드려하지말고 이름부터 만들어라
