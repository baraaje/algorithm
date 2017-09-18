import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 평균
 * 
 * @author inho.a.choi
 *
 */
public class P1546 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1546.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] data = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
			max = Math.max(max, data[i]);
		}

		double sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += (double) data[i] / max * 100;
		}
		System.out.printf("%.2f\n", (double) sum / N);
		sc.close();
	}
}
