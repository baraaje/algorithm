import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P2108 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P2108.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] data = new int[N + 1];
		int[] count = new int[8001];

		long sum = 0;
		int maxCount = -1;
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
			count[data[i] + 4000]++;

			if (maxCount < count[data[i] + 4000]) {
				maxCount = count[data[i] + 4000];
			}
			sum += data[i];
		}

		int maxCountIndex = 0;
		boolean first = false;
		for (int i = 1; i <= 8000; i++) {
			if (count[i] == maxCount) {
				maxCountIndex = i;
				if (first) {
					break;
				} else {
					first = true;
				}
			}
		}

		Arrays.sort(data, 1, N + 1);
		System.out.printf("%.0f\n", (double) sum / N);
		System.out.println(data[N / 2 + 1]);
		System.out.println(maxCountIndex - 4000);
		System.out.println(data[N] - data[1]);

		sc.close();
	}
}
