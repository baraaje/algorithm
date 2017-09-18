import java.io.FileInputStream;
import java.util.Scanner;

/**
 * OX퀴즈
 * 
 * @author inho.a.choi
 *
 */
public class P8958 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P8958.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int score = 0;
			int seq = 0;
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					seq++;
					score += seq;
				} else {
					seq = 0;
				}
			}
			System.out.println(score);
		}
		sc.close();
	}
}