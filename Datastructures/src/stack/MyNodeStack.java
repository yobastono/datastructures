package stack;

public class MyNodeStack<T> {
	public  MyNode<T> top;
	MyNode<T> head;

	public T getTopValue() {
		if (top == null) return null;
		return top.value;
	}
	
	public static void main(String[]args) {
		MyNodeStack<Integer> mNS = new MyNodeStack<>();
		mNS.push(1);
		mNS.push(2);
		mNS.push(3);
		mNS.push(4);
		mNS.showUpDown();
		System.out.println("----------------");
		System.out.println(mNS.pop());
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println(mNS.pop());
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println(mNS.pop());
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println(mNS.pop());
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println(mNS.pop());
		System.out.println("----------------");
		mNS.showUpDown();

	}
	
	public T push(T value) {
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
		return node.value;

	}
	
	public T pop() {
		if(this.isEmpty()) {
			return null;
		}
		MyNode<T> res = top;
		if(top == null) {
			return null;
		} else {
			res.value = top.value;
			top = top.prev;
			//top.next = null;
		}
		return res.value;
	}
	
	public boolean isEmpty() {
		return top == null;
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
