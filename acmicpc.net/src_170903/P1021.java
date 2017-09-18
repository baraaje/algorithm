import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 회전하는 큐
 * 
 * @author inho.a.choi
 *
 */
public class P1021 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1021.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] ms = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			ms[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 1; i <= M; i++) {
			boolean ccw = ms[i] <= N / 2 + 1;
			int d = ccw ? (ms[i] - 1) : (N - ms[i] + 1);
			ms[i] = rotate(ms[i], ccw, d, N);
			ms[i] = remove(ms[i]);
			for (int j = i + 1; j <= M; j++) {
				ms[j] = rotate(ms[j], ccw, d, N);
				ms[j] = remove(ms[j]);
			}
			System.out.println(Arrays.toString(ms));
			count += d;
			N--;
		}
		System.out.println(count);
		sc.close();
	}

	private static int rotate(int i, boolean ccw, int d, int n) {
		if (ccw) {
			// 1 2 3 4 5
			return (i - d) > 0 ? i - d : n + i - d;
		}
		return (i + d) > n ? (i + d) % n : i + d;
	}

	private static int remove(int i) {
		return i - 1;
	}
}
