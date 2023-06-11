package 자료구조_9장_트리;
//홍세현
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

	//현재 노드의 다음에 방문해야 할 노드를 찾는 메서드
	TreeNode inorderSucc(TreeNode current) { //successor 
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	//current가 자식 노드가 없는 노드인지 확인
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
	    if (root == null) {
	        return false; 
	    }
	    TreeNode p = root, q = null;
	  
	    while (p != null && p.data != num) {
	        q = p;

	        if (num < p.data) {
	            p = p.LeftChild;
	        } else {
	            p = p.RightChild;
	        }
	    }

	    if (p == null) {
	        return false; 
	    }

	    //child가 없는 노드 삭제
	    if (isLeafNode(p)) {
	        if (p == root) {
	            root = null;
	        } 
	        else if (p == q.LeftChild) {
	            q.LeftChild = null;
	        } 
	        else {
	            q.RightChild = null;
	        }
	    }
	    //child가 1개인 노드 삭제
	    else if (p.RightChild == null) {
	        if (p == root) {
	            root = p.LeftChild;
	        } else if (p == q.LeftChild) {
	            q.LeftChild = p.LeftChild;
	        } else {
	            q.RightChild = p.LeftChild;
	        }
	    } 
	    
	    else if (p.LeftChild == null) {
	        if (p == root) {
	            root = p.RightChild;
	        } else if (p == q.LeftChild) {
	            q.LeftChild = p.RightChild;
	        } else {
	            q.RightChild = p.RightChild;
	        }
	    }
	    //child가 2개인 노드 삭제
	    else {
	        TreeNode s = inorderSucc(p);
	        if (p == root) {
	            root = s;
	        } else if (p == q.LeftChild) {
	            q.LeftChild = s;
	        } else {
	            q.RightChild = s;
	        }
	        s.LeftChild = p.LeftChild;
	    }

	    return true;
	}
	
	
	
	boolean search(int num) {
		TreeNode p = root;
		if (p == null) {
			return false;
		}
		while(p!=null) {
			if(p.data == num) {
				return true;
			}
			else if (p.data > num) {
				p = p.LeftChild;
			} else
				p = p.RightChild;
		}
		return false;
		
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

