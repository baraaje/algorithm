import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 베르트랑 공준
 * 
 * @author inho.a.choi
 *
 */
public class P4948 {
	private static int MAX_N = 1000000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P4948.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int[] d = new int[MAX_N + 1];
		d[0] = d[1] = 1;
		for (int i = 2; i <= MAX_N; i++) {
			if (d[i] == 0) {
				for (int j = i * 2; j <= MAX_N; j += i) {
					d[j] = 1;
				}
			}
		}

		for (;;) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}

			int cnt = 0;
			int nn = 2 * n;
			for (int i = n+1; i <= nn; i++) {
				if (d[i] == 0) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}

		sc.close();
	}
}
