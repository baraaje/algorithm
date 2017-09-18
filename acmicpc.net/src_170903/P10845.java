import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P10845 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P10845.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		// push X: 정수 X를 큐에 넣는 연산이다.
		// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// size: 큐에 들어있는 정수의 개수를 출력한다.
		// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		int N = sc.nextInt();
		int[] q = new int[10000];
		int front = 0;
		int back = 0;
		for (int i = 1; i <= N; i++) {
			String cmd = sc.next();
			if ("push".equals(cmd)) {
				q[back++] = sc.nextInt();
			} else if ("pop".equals(cmd)) {
				System.out.println(front == back ? -1 : q[front++]);
			} else if ("size".equals(cmd)) {
				System.out.println(back - front);
			} else if ("empty".equals(cmd)) {
				System.out.println(front == back ? 1 : 0);
			} else if ("front".equals(cmd)) {
				System.out.println(front == back ? -1 : q[front]);
			} else if ("back".equals(cmd)) {
				System.out.println(front == back ? -1 : q[back - 1]);
			}
		}
		sc.close();
	}
}
