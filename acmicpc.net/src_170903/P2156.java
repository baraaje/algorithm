import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 포도주 시식
 * 
 * @author inho.a.choi
 *
 */
public class P2156 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P2156.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		// A[i] = i번째 포도주 잔의 양
		// D[i] = i번째 포도주 잔까지 왔을때 최대 포도주 양
		// D[i][j] = i번째 포도주 잔까지 왔을때 최대 포도주 양, 연속해서 j잔째 인 경우
		//
		// D[i][0] = max(D[i-1][0], D[i-1][1], D[i-1][2])
		// D[i][1] = D[i-1][0] + A[i]
		// D[i][2] = D[i-1][1] + A[i]

		int n = sc.nextInt();
		int[] A = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		int[][] D = new int[n + 1][3];
		D[1][1] = A[1];
		for (int i = 2; i <= n; i++) {
			D[i][0] = max(D[i - 1][0], D[i - 1][1], D[i - 1][2]);
			D[i][1] = D[i - 1][0] + A[i];
			D[i][2] = D[i - 1][1] + A[i];
		}
		System.out.println(max(D[n][0], D[n][1], D[n][2]));
		sc.close();
	}

	static int max(int n1, int n2, int n3) {
		return Math.max(Math.max(n1, n2), n3);
	}
}
