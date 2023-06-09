package 자료구조_9장_트리;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;


//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode(int x) {
		data = x;
		LeftChild = RightChild = null;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) { //successor 
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild); //왼족으로 가라
			System.out.print(" " + CurrentNode.data); //데이터를 찍어라
			inorder(CurrentNode.RightChild); //오른쪽으로 가라
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " "); //데이터를 먼저 찍고
			preorder(CurrentNode.LeftChild); //왼쪽으로
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현		
		TreeNode p = root,  q=p;
//		int branchMode = 0;
//		if(branchMode == 1)
//			q.LeftChild = new TreeNode(1);
//		if(branchMode == 2)
//			q.RightChild = new TreeNode(2);
		TreeNode tmp = new TreeNode(x);
		
		if(p == null ) {
			root = tmp;
			return false;
		}
		while(p!=null) {
			q = p;
			if(x <= p.data) {

				p = p.LeftChild;
			}
			else if(x > p.data) {
				p = p.RightChild;
			}
			
		}
		if(q.data >= x) {
			q.LeftChild = tmp;
		}
		else {
			q.RightChild = tmp;
		}
		return true;
	}

	boolean delete(int num) {
		TreeNode p = root,  q=p;
		//child가 없는 노드 삭제
		
		while (p != null ) {
			if (p.data != num) {
				q = p;
				if (num < p.data) {
					p = p.LeftChild;
				}
				else if(num > p.data) {
					p = p.RightChild;
				}
				
			}
			if(p.data == num) {
				p = null;
//				if(q.data > num) {
//					q.LeftChild = null;
//					q.LeftChild =
//				}
				return true;
			}
		}
		
		return false;
		
		//child가 1개인 노드 삭제
		//child가 2개인 노드 삭제

	}

	boolean search(int num) {
		TreeNode p = root;
		if (p == null) {
			return false;
		}
		while(p!=null) {
			if(p.data == num) {
				break;
			}
			else if (p.data > num) {
				p = p.LeftChild;
			} else
				p = p.RightChild;
		}
		return true;
		
	}
}

public class BinaryTree_int {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}

