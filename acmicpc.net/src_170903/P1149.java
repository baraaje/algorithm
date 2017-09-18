import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * RGB거리
 * 
 * @author inho.a.choi
 *
 */
public class P1149 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1149.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] A = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		int[][] D = new int[N + 1][3];
		for (int i = 0; i < 3; i++) {
			D[1][i] = A[1][i];
		}
		for (int i = 2; i <= N; i++) {
			D[i][0] = Math.min(D[i - 1][1], D[i - 1][2]) + A[i][0];
			D[i][1] = Math.min(D[i - 1][0], D[i - 1][2]) + A[i][1];
			D[i][2] = Math.min(D[i - 1][0], D[i - 1][1]) + A[i][2];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (ans > D[N][i]) {
				ans = D[N][i];
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
