import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Fly me to the Alpha Centauri
 * 
 * @author inho.a.choi
 *
 */
public class P1011 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1011.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int d = sc.nextInt();
			d = sc.nextInt() - d;

			int cnt = 0;
			int i = 1;
			for (; d > i * 2; i++, cnt += 2) {
				d -= i * 2;
			}
			cnt += d / i;
			if (d % i > 0) {
				cnt++;
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
