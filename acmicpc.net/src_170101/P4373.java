/**
 * 셀프 넘버
 * 
 * @author inho.a.choi
 *
 */
public class P4373 {
	public static void main(String[] args) throws Exception {
		int N = 10000;
		int[] n = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (n[i] == 0) {
				// i로 생성되는 순열은 모두 지운다
				int a = i;
				while (true) {
					a = d(a);
					if (a > N)
						break;
					n[a] = 1;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (n[i] == 0) {
				System.out.println(i);
			}
		}
	}

	private static int d(int a) {
		int b = a;
		for (; b > 0; b /= 10) {
			a += b % 10;
		}
		return a;
	}
}
