import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 골드바흐의 추측
 * 
 * @author inho.a.choi
 *
 */
public class P9020 {
	private static int MAX_N = 10000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P9020.class.getCanonicalName() + ".txt")));
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

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			for (int i = n / 2; i >= 2; i--) {
				if (d[i] == 0 && d[n - i] == 0) {
					System.out.println(i + " " + (n - i));
					break;
				}
			}
		}

		sc.close();
	}
}
