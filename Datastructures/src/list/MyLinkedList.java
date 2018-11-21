package list;

import java.util.Comparator;

public class MyLinkedList<T> {
	protected MyNode<T> head;

	public static void main(String[] args) {
		MyLinkedList<Employee_Company_A> mLL = new MyLinkedList<>();

		Comparator<Employee_Company_A> compA = new CompareByName();

		mLL.insertAlphabetically((new Employee_Company_A("Robert")), compA);
		mLL.insertAlphabetically((new Employee_Company_A("Maria")), compA);
		mLL.insertAlphabetically((new Employee_Company_A("Simon")), compA);
		mLL.insertAlphabetically((new Employee_Company_A("Zorro")), compA);
		mLL.insertAlphabetically((new Employee_Company_A("Fata")), compA);

		mLL.show();
	}

	public void insert(T t) {

		// node.next = null;
		if (head == null) {
			head = new MyNode<T>(t);
		} else {
			MyNode<T> node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = node;
		}
	}

	public void insertAlphabetically(T value, Comparator<T> comp) {
		MyNode<T> node = new MyNode<>(value);
		// node.next = null;
		if (head == null) {
			head = node;
		} else {
			MyNode<T> n = head;
			MyNode<T> prev = null;
			while (n != null) {
				if (comp.compare(node.t, n.t) < 0) {
					break;
				}
				prev = n;
				n = n.next;
			}
			if (head == n) {
				node.next = n;
				head = node;
				//prev = node;
			} else {
				prev.next = node;
				node.next = n;
			}
		}
	}

	public void show() {
		MyNode<T> iter = new MyNode<>();
		iter = head;
		while (iter != null) {
			System.out.println(iter.t);
			iter = iter.next;
		}
	}

}

class MyNode<T> {
	// static final int item = 0;
	MyNode<T> next;
	T t;

	public MyNode(T t) {
		this.t = t;
	}

	public MyNode() {

	}
}

class CompareByName implements Comparator<Employee_Company_A> {

	@Override
	public int compare(Employee_Company_A e1, Employee_Company_A e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
