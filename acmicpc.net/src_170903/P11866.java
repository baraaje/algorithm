import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 조세퍼스 문제 0
 * 
 * @author inho.a.choi
 *
 */
public class P11866 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		System.out.printf("<%d", pickup(q, M));
		while (!q.isEmpty()) {
			System.out.printf(", %d", pickup(q, M));
		}
		System.out.println(">");

		sc.close();
	}

	private static int pickup(Queue<Integer> q, int m) {
		for (int i = 1; i < m; i++) {
			q.offer(q.poll());
		}
		return q.poll();
	}
}
