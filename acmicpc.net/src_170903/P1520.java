import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막 길
 * 
 * @author inho.a.choi
 *
 */
public class P1520 {
	private static int[][] MAP;
	private static int M;
	private static int N;
	private static int[][] D;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1520.class.getCanonicalName() + ".txt")));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		MAP = new int[M + 1][N + 1];
		D = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(reader.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				D[i][j] = -1;
			}
		}

		System.out.println(dfs(1, 1));
	}

	private static int dfs(int i, int j) {
		if (i == M && j == N) {
			return 1;
		}

		if (D[i][j] != -1) {
			return D[i][j];
		}
		int sum = 0;
		// 상
		if (i > 1 && MAP[i - 1][j] < MAP[i][j]) {
			sum += dfs(i - 1, j);
		}
		// 하
		if (i < M && MAP[i + 1][j] < MAP[i][j]) {
			sum += dfs(i + 1, j);
		}
		// 좌
		if (j > 1 && MAP[i][j - 1] < MAP[i][j]) {
			sum += dfs(i, j - 1);
		}
		// 우
		if (j < N && MAP[i][j + 1] < MAP[i][j]) {
			sum += dfs(i, j + 1);
		}
		return D[i][j] = sum;
	}

}
