import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 소수
 * 
 * @author inho.a.choi
 *
 */
public class P2581 {
	private static int MAX_N = 10000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P2581.class.getCanonicalName() + ".txt")));
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
		int M = sc.nextInt();
		int N = sc.nextInt();

		long sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {
			if (d[i] == 0) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		if (sum > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
		sc.close();
	}
}
