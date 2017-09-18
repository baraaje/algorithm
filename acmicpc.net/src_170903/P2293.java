import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 동전 1
 * 
 * @author inho.a.choi
 *
 */
public class P2293 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P2293.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] D = new int[k + 1];
		D[0] = 1;
		for (int i = 1; i <= n; i++) {
			int v = sc.nextInt();
			for (int j = 1; j <= k; j++) {
				if (j >= v) {
					D[j] = D[j] + D[j - v];
				}
			}
		}
		System.out.println(D[k]);
		sc.close();
	}
}
