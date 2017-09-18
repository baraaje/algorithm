import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 사전
 * 
 * @author inho.a.choi
 *
 */
public class P4344 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P4344.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		for (int i = 1; i <= C; i++) {
			int N = sc.nextInt();
			int[] data = new int[N + 1];
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				data[j] = sc.nextInt();
				sum += data[j];
			}
			int cnt = 0;
			double avg = (double) sum / N;
			for (int j = 1; j <= N; j++) {
				if (data[j] > avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", (double) cnt / N * 100);
		}

		sc.close();
	}
}
