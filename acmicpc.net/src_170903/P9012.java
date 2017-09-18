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
public class P9012 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P9012.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			String str = sc.next();
			Stack<Character> stack = new Stack<Character>();
			boolean vps = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					stack.push(c);
				} else {
					if (!stack.empty() && stack.peek() == '(') {
						stack.pop();
					} else {
						vps = false;
						break;
					}
				}
			}
			if (vps && stack.empty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		sc.close();
	}
}
