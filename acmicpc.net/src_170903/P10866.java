import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 덱
 * 
 * @author inho.a.choi
 *
 */
public class P10866 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P10866.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		// push_front X: 정수 X를 덱의 앞에 넣는다.
		// push_back X: 정수 X를 덱의 뒤에 넣는다.
		// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// size: 덱에 들어있는 정수의 개수를 출력한다.
		// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
		// front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		int N = sc.nextInt();
		Deque<Integer> q = new ArrayDeque<Integer>();

		for (int i = 0; i < N; i++) {
			String cmd = sc.next();
			if ("push_front".equals(cmd)) {
				int X = sc.nextInt();
				q.addFirst(X);
			} else if ("push_back".equals(cmd)) {
				int X = sc.nextInt();
				q.addLast(X);
			} else if ("pop_front".equals(cmd)) {
				System.out.println(q.isEmpty() ? -1 : q.pollFirst());
			} else if ("pop_back".equals(cmd)) {
				System.out.println(q.isEmpty() ? -1 : q.pollLast());
			} else if ("size".equals(cmd)) {
				System.out.println(q.size());
			} else if ("empty".equals(cmd)) {
				System.out.println(q.isEmpty() ? 1 : 0);
			} else if ("front".equals(cmd)) {
				System.out.println(q.isEmpty() ? -1 : q.peekFirst());
			} else if ("back".equals(cmd)) {
				System.out.println(q.isEmpty() ? -1 : q.peekLast());
			}
		}
		sc.close();
	}
}
