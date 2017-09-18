import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * 타임머신
 * 
 * @author inho.a.choi
 *
 */
public class P11657 {
	static class Edge {
		int ns;
		int ne;
		int w;

		public Edge(int ns, int ne, int w) {
			this.ns = ns;
			this.ne = ne;
			this.w = w;
		}

		@Override
		public String toString() {
			return "(" + this.ns + "," + this.ne + " : " + this.w + ")";
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P11657.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] d = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		Edge[] edges = new Edge[M + 1];
		for (int i = 1; i <= M; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		boolean update = true;
		for (int i = 1; update && i <= N; i++) {
			update = false;
			for (int j = 1; j <= M; j++) {
				if (d[edges[j].ns] != Integer.MAX_VALUE && d[edges[j].ne] > d[edges[j].ns] + edges[j].w) {
					update = true;
					d[edges[j].ne] = d[edges[j].ns] + edges[j].w;
				}
			}
		}
		for (int i = 1; i <= M; i++) {
			if (d[edges[i].ne] > d[edges[i].ns] + edges[i].w) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		for (int i = 2; i <= N; i++) {
			System.out.println(d[i] == Integer.MAX_VALUE ? -1 : d[i]);
		}

		sc.close();
	}
}
