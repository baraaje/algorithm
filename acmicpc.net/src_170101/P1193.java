import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 분수찾기
 * 
 * @author inho.a.choi
 *
 */
public class P1193 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1193.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();  // 3
		int n = 0;
		while (X > 0) {
			if (X <= n + 1) {
				if ((n + 1) % 2 == 1) {
					System.out.println((n + 2 - X) + "/" + X);
				} else {
					System.out.println(X + "/" + (n + 2 - X));
				}
				break;
			}
			n++;
			X -= n;
		}
		sc.close();
	}
}
