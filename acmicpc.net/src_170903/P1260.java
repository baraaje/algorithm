import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P1260 {
	private static int[][] G;
	private static int N;
	private static int M;
	private static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1260.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt();

		G = new int[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			G[v1][v2] = G[v2][v1] = 1;
		}

		visit = new boolean[N + 1];
		DFS(V);
		System.out.println();

		for (int i = 1; i <= N; i++) {
			visit[i] = false;
		}
		BFS(V);

		sc.close();
	}

	private static void BFS(int v) {
		int[] q = new int[1000];
		int front = 0;
		int back = 0;

		q[back++] = v;
		System.out.print(v + " ");
		visit[v] = true;

		while (front < back) {
			v = q[front++];
			for (int i = 1; i <= N; i++) {
				if (G[v][i] == 1 && !visit[i]) {
					q[back++] = i;
					System.out.print(i + " ");
					visit[i] = true;
				}
			}
		}
	}

	private static void DFS(int v) {
		visit[v] = true;
		System.out.print(v + " ");

		for (int i = 1; i <= N; i++) {
			if (G[v][i] == 1 && !visit[i]) {
				DFS(i);
			}
		}
	}
}
