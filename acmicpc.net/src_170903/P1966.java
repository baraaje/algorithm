import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P1966 {
	static class Doc implements Comparable<Doc> {
		int n;
		int p;

		public Doc(int n, int p) {
			this.n = n;
			this.p = p;
		}

		@Override
		public int compareTo(Doc o) {
			if (o.p == this.p && o.n == this.n) {
				return 0;
			}
			return this.p - o.p;
		}

		@Override
		public String toString() {
			return "(" + this.n + ":" + this.p + ")";
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1966.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			Queue<Doc> q = new LinkedList<Doc>();
			PriorityQueue<Doc> maxHeap = new PriorityQueue<Doc>(10, Collections.reverseOrder());
			for (int i = 0; i < N; i++) {
				Doc d = new Doc(i, sc.nextInt());
				q.offer(d);
				maxHeap.offer(d);
			}

			int cnt = 0;
			for (Doc d = q.poll();; d = q.poll()) {
				if (d.p == maxHeap.peek().p) {
					cnt++;
					if (d.n == M) {
						break;
					}
					maxHeap.remove(d);
				} else {
					q.offer(d);
				}
			}
			System.out.println(cnt);
		}

		sc.close();
	}
}
