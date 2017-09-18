import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호
 * 
 * @author inho.a.choi
 *
 */
public class P2504 {
	static class E {
		char c;
		int n;
		boolean isChar;

		public E(int n) {
			this.n = n;
			this.isChar = false;
		}

		public E(char c) {
			this.c = c;
			this.isChar = true;
		}

		@Override
		public String toString() {
			if (isChar) {
				return "" + c;
			} else {
				return "" + n;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P2504.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		boolean valid = true;
		Stack<E> stack = new Stack<E>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(' || c == '[') {
				stack.push(new E(c));
			} else {
				if (c == ')') {
					int sub = 0;
					while (!stack.empty() && !stack.peek().isChar) {
						sub += stack.pop().n;
					}
					if (!stack.empty() && stack.peek().c == '(') {
						stack.pop();
						sub = (sub == 0) ? 2 : 2 * sub;
						stack.push(new E(sub));
					} else {
						valid = false;
						break;
					}
				} else if (c == ']') {
					int sub = 0;
					while (!stack.empty() && !stack.peek().isChar) {
						sub += stack.pop().n;
					}
					if (!stack.empty() && stack.peek().c == '[') {
						stack.pop();
						sub = (sub == 0) ? 3 : 3 * sub;
						stack.push(new E(sub));
					} else {
						valid = false;
						break;
					}
				}
			}
		}
		int sum = 0;
		if (valid) {
			for (E e : stack) {
				if (!e.isChar) {
					sum += e.n;
				} else {
					sum = 0;
					break;
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
