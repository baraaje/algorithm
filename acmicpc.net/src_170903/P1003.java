import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 피보나치 함수
 * 
 * @author inho.a.choi
 *
 */
public class P1003 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1003.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		// D[N][0] = N일때 0을 호출한 회수
		// = D[N-1][0] + D[N-2][0]
		// D[N][1] = N일때 1을 호출한 회수
		// = D[N-1][1] + D[N-2][1]
		int N = 40;
		int[][] D = new int[N + 1][2];
		D[0][0] = 1;
		D[0][1] = 0;
		D[1][0] = 0;
		D[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i - 1][0] + D[i - 2][0];
			D[i][1] = D[i - 1][1] + D[i - 2][1];
		}

		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int n = sc.nextInt();
			System.out.println(D[n][0] + " " + D[n][1]);
		}

		sc.close();
	}
}
