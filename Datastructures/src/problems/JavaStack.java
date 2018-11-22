package problems;

import stack.*;

// hopefully right, there is probably a better solution ;) 

public class JavaStack {

	public static void main(String[] args) {
//		System.out.println(checkBrackets("[([]{})]"));
		System.out.println("1 " + checkBrackets3("()[]")); // true
		System.out.println("2 " + checkBrackets3("()[])")); // false
		System.out.println("3 " + checkBrackets3("()[])(")); // false
		System.out.println("4 " + checkBrackets3("[)([]{})])")); // false
		System.out.println("5 " + checkBrackets3("{[()]}")); // true
		System.out.println("6 " + checkBrackets3("[()]")); // true



	}

	public static boolean checkBrackets3(String str) {
		// length of string must be an even number and not empty to be true
		if(str.equals("") || str.length() % 2 != 0) return false;
		
		// assign brackets to char variables
		char a, b, c, d, e, f;
		a = '('; b = ')'; c = '['; d = ']'; e = '{'; f = '}';
		
		// since using the stack create one
		MyNodeStack<Character> mNS = new MyNodeStack<>();
		
		//topChar will have value of Top Node, charBefore of value under top
		char topChar;
		char charBefore = '!';
		
		// starting while loop with 1 and assign to topChar first char of string
		topChar = mNS.push(str.charAt(0));
		int i = 1;
		// it ends when str is over
		while(i < str.length()) {
			
			// first loop is never empty because of topChar = ..
			if(mNS.isEmpty()) {
				charBefore = mNS.push(str.charAt(i));
				topChar = mNS.push(str.charAt(i + 1));
				i++;
			} else {
				// don't want to confront same character
				if(charBefore != mNS.getTopValue()) {
				// assign charBefore to topChar, like prev with list
					charBefore = topChar;
				}
				// topChar becomes the next one, like iter with list
				topChar = mNS.push(str.charAt(i));
			}
			
			// if two specific chars in specific order are in next to each other
			// pop them both
			if((charBefore == a && topChar == b) ||
					(charBefore == c && topChar == d) ||
					(charBefore == e && topChar == f)) {
				mNS.pop();
				mNS.pop();
				
				// if empty see the first if under the while in next loop
				if(!mNS.isEmpty()) {
					charBefore = mNS.getTopValue();
				}
			}
			i++;
		}
		
		// stack must be empty to be true
		if(mNS.isEmpty()) {
			return true;
		}
		// else false
		return false;
		
	}
}
