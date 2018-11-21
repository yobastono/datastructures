package stack;

public class MyArrayStack {
	
	int capacity = 2;
	int top = -1;
	int[] stack = new int[capacity];
	
	public static void main(String[]args) {
		MyArrayStack mAS = new MyArrayStack();
		mAS.push(1);
		mAS.push(2);
		mAS.push(3);
		mAS.push(4);
		mAS.push(5);
		mAS.show();
		mAS.pop();
		mAS.pop();
		mAS.pop();
		mAS.pop();
		mAS.pop();
		mAS.pop(); // see if it still pops when capacity = 0
		System.out.println();
		mAS.show();
	}
	
	
	public void push(int value) {
		if(++top == capacity) {
			capacity *= 2;
			stack = expand(stack);
		}
		stack[top] = value;
		System.out.println("top is: " + top + " and num is: " + stack[top]);
	}
	
	public int pop() {
		if(top == -1) {
			return top;
		} else {
			System.out.println("top is: " + top + " and num is: " + stack[top]);
			int res = stack[top--];
			if(top + 1 == capacity / 2) {
				stack = shrink(stack);
				capacity /= 2;
			}
			return res;
		}

	}

	private int[] shrink(int[] stack2) {
		int[] res = new int[stack2.length / 2];
		for(int i = 0; i < res.length; i++) {
			res[i] = stack2[i];
		}
		return res;
	}

	private int[] expand(int[] stack2) {
		int[] res = new int[capacity];
		for(int i = 0; i < capacity / 2; i++) {
			res[i] = stack2[i];
		}
		return res;
	}


	public void show() {
		for(Integer i : stack) {
			System.out.println(i);
		}
	}
}
