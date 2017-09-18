import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 사전
 * 
 * @author inho.a.choi
 *
 */
public class P1256 {
	private static long[][] combi;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1256.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		combi = new long[201][201];
		combi[0][0] = 1;
		for (int i = 1; i <= 200; i++) {
			combi[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				combi[i][j] = combi[i - 1][j - 1] + combi[i - 1][j];
			}
		}

		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("%d ", combi[i][j]);
			}
			System.out.println();
		}

		char[] str = new char[N + M + 1];
		f(str, 1, K, N, M);

		System.out.println(new String(str, 1, N+M));
		sc.close();
	}

	private static void f(char[] str, int idx, long k, int n, int m) {
		if (idx > str.length) {
			return;
		}
		if (n == 0) {
			for (int i = idx; i < str.length; i++) {
				str[i] = 'z';
			}
			return;
		}
		if (m == 0) {
			for (int i = idx; i < str.length; i++) {
				str[i] = 'a';
			}
			return;
		}

		long count = combi[n + m - 1][n - 1];
		if (count < k) {
			str[idx] = 'z';
			f(str, idx + 1, k - count, n, m - 1);
		} else {
			str[idx] = 'a';
			f(str, idx + 1, k, n - 1, m);
		}
	}
}
