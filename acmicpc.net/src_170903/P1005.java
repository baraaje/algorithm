import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ACM Craft
 * 
 * @author inho.a.choi
 *
 */
public class P1005 {
	private static ArrayList<Integer>[] bArr;
	private static int[] A;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P1005.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		// A[i] = 건물 i를 건설완료하는데 드는 시간
		// D[i] = 건물 i를 건설완료하는데 드는 최소시간
		// = max(D[j], j=i를 건설완료하는필요한 건물) + A[i]

		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			A = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				A[i] = sc.nextInt();
			}
			bArr = new ArrayList[N + 1];
			for (int i = 1; i <= K; i++) {
				int bs = sc.nextInt();
				int be = sc.nextInt();
				if (bArr[be] == null) {
					bArr[be] = new ArrayList<Integer>();
				}
				bArr[be].add(bs);
			}

			int W = sc.nextInt();
			int[] D = new int[N + 1];
			System.out.println(f(D, W));
		}

		sc.close();
	}

	private static int f(int[] D, int w) {
		if (D[w] != 0) {
			return D[w];
		}
		int ret = 0;
		if (bArr[w] != null && bArr[w].size() > 0) {
			for (int n : bArr[w]) {
				ret = Math.max(ret, f(D, n));
			}
			ret += A[w];
		} else {
			ret = A[w];
		}
		return D[w] = ret;
	}
}
