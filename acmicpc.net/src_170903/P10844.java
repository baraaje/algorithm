import java.util.Scanner;

/**
 * 쉬운 계단 수
 * 
 * @author inho.a.choi
 *
 */
public class P10844 {
	static int MOD = 1000000000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// D[N][L] = 마지막 자리수가 L인 N자리 계단수의 수
		// = D[N-1][L-1] + D[N-1][L+1]
		int[][] D = new int[N + 1][10];
		for (int i = 1; i <= 9; i++) {
			D[1][i] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i > 1) {
					if (j > 0) {
						D[i][j] += D[i - 1][j - 1];
					}
					if (j < 9) {
						D[i][j] += D[i - 1][j + 1];
					}
					D[i][j] %= MOD;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += D[N][i];
			sum %= MOD;
		}
		System.out.println(sum);
		sc.close();
	}
}
