import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * 웜홀
 * 
 * @author inho.a.choi
 *
 */
public class P1865 {
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
		System.setIn(new FileInputStream(new File("res_170903/" + P1865.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int W = sc.nextInt();

			Edge[] edges = new Edge[M * 2 + W + 1];
			for (int i = 1; i <= M; i++) {
				int S = sc.nextInt();
				int E = sc.nextInt();
				int T = sc.nextInt();

				edges[i * 2 - 1] = new Edge(S, E, T);
				edges[i * 2] = new Edge(E, S, T);
			}

			for (int i = 1; i <= W; i++) {
				int S = sc.nextInt();
				int E = sc.nextInt();
				int T = sc.nextInt();

				edges[2 * M + i] = new Edge(S, E, -1 * T);
			}

			int[] d = new int[N + 1];
			for (int i = 2; i <= N; i++) {
				d[i] = Integer.MAX_VALUE;
			}

			for (int i = 1; i <= N-1; i++) {
				for (int j = 1; j < edges.length; j++) {
					if (d[edges[j].ns] != Integer.MAX_VALUE && d[edges[j].ne] > d[edges[j].ns] + edges[j].w) {
						d[edges[j].ne] = d[edges[j].ns] + edges[j].w;
					}
				}
			}
			boolean cycle = false;
			for (int i = 1; i <= M; i++) {
				if (d[edges[i].ne] > d[edges[i].ns] + edges[i].w) {
					cycle = true;
					break;
				}
			}
			System.out.println(cycle ? "YES" : "NO");
		}
		sc.close();
	}
}
