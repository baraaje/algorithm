import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 문자열 반복
 * 
 * @author inho.a.choi
 *
 */
public class P2675 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P2675.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int R = sc.nextInt();
			String S = sc.next();

			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				for (int j = 0; j < R; j++) {
					System.out.print(c);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
