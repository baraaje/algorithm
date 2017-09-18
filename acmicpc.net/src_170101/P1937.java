import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author inho.a.choi
 *
 */
public class P1937 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1937.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		arr = new int[n][n];
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, recur(i, j, n));
			}
		}

		System.out.println(ans);
	}

	private static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static int[][] arr;
	private static int[][] d;

	private static int recur(int i, int j, int n) {
		if (d[i][j] != 0) {
			return d[i][j];
		}
		d[i][j] = 1;
		for (int k = 0; k < 4; k++) {
			int nexti = i + dir[k][0];
			int nextj = j + dir[k][1];

			if (0 <= nexti && nexti < n && 0 <= nextj && nextj < n) {
				if (arr[nexti][nextj] > arr[i][j]) {
					d[i][j] = Math.max(d[i][j], recur(nexti, nextj, n) + 1);
				}
			}
		}
		return d[i][j];
	}
}
