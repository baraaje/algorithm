import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 최소값과 최대값
 * 
 * @author inho.a.choi
 *
 */
public class P2357 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P2357.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] data = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}

		int nn = 1;
		for (; nn <= N;) {
			nn *= 2;
		}
		int[][] tree = new int[2 * nn][2];

		// 초기화
		for (int i = 1; i <= 2 * nn - 1; i++) {
			tree[i][0] = Integer.MAX_VALUE;
			tree[i][1] = Integer.MIN_VALUE;
		}
		for (int i = 1; i <= N; i++) {
			tree[i + nn - 1][0] = tree[i + nn - 1][1] = data[i];
		}
		for (int i = nn - 1; i >= 1; i--) {
			tree[i][0] = Math.min(tree[i * 2][0], tree[i * 2 + 1][0]);
			tree[i][1] = Math.max(tree[i * 2][1], tree[i * 2 + 1][1]);
		}

		// 구간별 최소값, 최대값 찾기
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			a += nn - 1;
			b += nn - 1;

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			while (a <= b) {
				if (a % 2 == 1) {
					min = Math.min(tree[a][0], min);
					max = Math.max(tree[a][1], max);
				}
				if (b % 2 == 0) {
					min = Math.min(tree[b][0], min);
					max = Math.max(tree[b][1], max);
				}

				if (a == b) {
					break;
				}
				a = (a + 1) / 2;
				b = (b - 1) / 2;
			}

			System.out.println(min + " " + max);
		}

		sc.close();
	}
}
