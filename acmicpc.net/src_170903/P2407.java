import java.math.BigInteger;
import java.util.Scanner;

/**
 * 조합
 * 
 * @author inho.a.choi
 *
 */
public class P2407 {
	static BigInteger[][] d = new BigInteger[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		// nCm = n-1Cm + n-1Cm-1
		System.out.println(combi(n, m));
		sc.close();
	}

	private static BigInteger combi(int n, int m) {
		if (n == m || m == 0) {
			return BigInteger.valueOf(1);
		}
		if (d[n][m] == null) {
			d[n][m] = combi(n - 1, m).add(combi(n - 1, m - 1));
		}
		return d[n][m];
	}
}
