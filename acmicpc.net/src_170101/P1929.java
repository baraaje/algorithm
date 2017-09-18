import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 소수 구하기
 * 
 * @author inho.a.choi
 *
 */
public class P1929 {
	private static int MAX_N = 1000000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1929.class.getCanonicalName() + ".txt")));
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
		for (int i = M; i <= N; i++) {
			if (d[i] == 0) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}
