import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * LCS
 * 
 * @author inho.a.choi
 *
 */
public class P9521 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P9521.class.getCanonicalName() + ".txt")));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		char[] ca1 = reader.readLine().toCharArray();
		char[] ca2 = reader.readLine().toCharArray();
		int n = ca1.length;
		int m = ca2.length;

		// A1[i] = A1 문자열의 i번째 문자
		// A2[j] = A2 문자열의 j번째 문자
		// D[i][j] = A1[i], A2[j]에서의 최장 공통 문자열 길이
		// if A1[i]!=A2[j], max(D[i-1][j], D[i][j-1])
		// if A1[i]==A2[j], D[i-1][j-1] + 1
		int[][] D = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (ca1[i - 1] == ca2[j - 1]) {
					D[i][j] = D[i - 1][j - 1] + 1;
				} else {
					D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
				}
			}
		}
		System.out.println(D[n][m]);
	}
}
