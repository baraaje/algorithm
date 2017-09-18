import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 수열
 * 
 * @author inho.a.choi
 *
 */
public class P1874 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1874.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		StringBuffer sb = new StringBuffer();
		int idx = 1;
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			while (stack.empty() || stack.peek() < a) {
				stack.push(idx++);
				sb.append("+\n");
			}
			if (!stack.empty() && a == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				System.exit(0);
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
