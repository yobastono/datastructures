package stack;

public class MyNodeStack<T> {
	MyNode<T> top;
	MyNode<T> head;
	
	public static void main(String[]args) {
		MyNodeStack<Integer> mNS = new MyNodeStack<>();
		mNS.push(1);
		mNS.push(2);
		mNS.push(3);
		mNS.push(4);
		mNS.push(5);
		mNS.push(6);
		mNS.push(7);
		mNS.push(8);
		mNS.showUpDown();
		System.out.println("----------------");
		System.out.println(mNS.pop());
		
		System.out.println("----------------");
		mNS.showUpDown();
		
	}
	
	public void push(T value) {
		MyNode<T> node = new MyNode<>();
		node.value = value;
		if(top == null) {
			top = node;
			head = node;
		} else {
			node.prev = top;
			top.next = node;
			top = node;
		}

	}
	
	public T pop() {
		MyNode<T> res = top;
		if(top == null) {
			return null;
		} else {
			res.value = top.value;
			top = top.prev;
			top.next = null;
		}
		return res.value;
	}
	
	public void showUpDown() {
		MyNode<T> n = top;
		while(n != null) {
			System.out.println(n.value);
			n = n.prev;
			
		}
	}
	public void showDownUp() {
		MyNode<T> n = head;
		while(n != null) {
			System.out.println(n.value);
			n = n.next;
		}
	}
}

class MyNode<T> {
	MyNode<T>next;
	MyNode<T> prev;
	T value;
}