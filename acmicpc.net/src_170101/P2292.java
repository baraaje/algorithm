import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 벌집
 * 
 * @author inho.a.choi
 *
 */
public class P2292 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P2292.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		// 1 + 6 + 2 * 6 + 3 * 6 + ... + i * 6
		int n = sc.nextInt() - 1;
		int i = 0;
		while (true) {
			int d = i * 6;
			if (n <= d) {
				break;
			}
			n -= d;
			i++;
		}
		System.out.println(i + 1);

		sc.close();
	}
}
