import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 집합의 표현
 * 
 * @author inho.a.choi
 *
 */
public class P1717 {
	private static int[][] combi;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1717.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		combi = new int[201][201];
		combi[1][1] = 1;
		for (int i = 2; i <= 200; i++) {
			combi[i][1] = 1;
			for (int j = 2; j <= i; j++) {
				combi[i][j] = combi[i - 1][j - 1] + combi[i - 1][j];
			}
		}

		char[] str = new char[N + M + 1];
		f(str, 1, K, N, M);

		sc.close();
	}

	private static void f(char[] str, int idx, int k, int n, int m) {
		if (idx > str.length) {
			return;
		}
		int count = combi[n + m - 1][n - 1];
		if (count < k) {
			str[idx] = 'z';
			f(str, idx + 1, k - count, n, m - 1);
		} else {
			str[idx] = 'a';
			f(str, idx + 1, k, n - 1, m);
		}
	}
}
