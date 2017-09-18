import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P10828 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P10828.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		// push X: 정수 X를 스택에 넣는 연산이다.
		// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// size: 스택에 들어있는 정수의 개수를 출력한다.
		// empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		// top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 1; i <= N; i++) {
			String cmd = sc.next();
			if ("push".equals(cmd)) {
				int X = sc.nextInt();
				stack.push(X);
			} else if ("pop".equals(cmd)) {
				System.out.println(stack.empty() ? -1 : stack.pop());
			} else if ("size".equals(cmd)) {
				System.out.println(stack.size());
			} else if ("empty".equals(cmd)) {
				System.out.println(stack.empty() ? 1 : 0);
			} else if ("top".equals(cmd)) {
				System.out.println(stack.empty() ? -1 : stack.peek());
			}
		}
		sc.close();
	}
}
