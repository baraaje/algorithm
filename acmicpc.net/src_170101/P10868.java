import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 최소값
 * 
 * @author inho.a.choi
 *
 */
public class P10868 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P10868.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// 완전이진트리 노드 수 = 2^h + 2^h - 1 = 2^(h+1) - 1
		int nn = 1;
		for (; nn <= N;) {
			nn *= 2;
		}
		int[] data = new int[N + 1];
		int[] tree = new int[2 * nn];

		// 데이터 읽기
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}

		// 초기화
		for (int i = 1; i <= 2 * nn - 1; i++) {
			tree[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= N; i++) {
			tree[i + nn - 1] = data[i];
		}
		for (int i = nn - 1; i >= 1; i--) {
			tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
		}

		// 구간별 최소값 찾기
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 리프 노드로 이동
			a += nn - 1;
			b += nn - 1;

			int min = Integer.MAX_VALUE;
			while (a <= b) {
				if (a % 2 == 1) {
					min = Math.min(tree[a], min);
				}
				if (b % 2 == 0) {
					min = Math.min(tree[b], min);
				}

				if (a == b)
					break;

				a = (a + 1) / 2;
				b = (b - 1) / 2;
			}

			System.out.println(min);
		}
		sc.close();
	}
}
