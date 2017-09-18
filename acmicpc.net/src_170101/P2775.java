import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 부녀회장이 될테야
 * 
 * @author inho.a.choi
 *
 */
public class P2775 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P2775.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int[][] a = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			a[0][i] = i;
		}
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				for (int b = 1; b <= j; b++) {
					a[i][j] += a[i - 1][b];
				}
			}
		}

		for (int i = 0; i <= 14; i++) {
			System.out.println(Arrays.toString(a[i]));
		}

		int T, k, n;
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			k = sc.nextInt();
			n = sc.nextInt();
			System.out.println(a[k][n]);
		}
		sc.close();
	}
}
