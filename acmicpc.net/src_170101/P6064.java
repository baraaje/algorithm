import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P6064 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P6064.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int cnt = -1;
			for (int i = 0; i < N; i++) {
				if ((i * M + x - 1) % N + 1 == y) {
					cnt = i * M + x;
					break;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
