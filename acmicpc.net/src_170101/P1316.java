import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 그룹 단어 체커
 * 
 * @author inho.a.choi
 *
 */
public class P1316 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1316.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			int[] alpha = new int[26];

			boolean group = true;
			int prev = -1;
			for (int k = 0; k < str.length(); k++) {
				int curr = str.charAt(k) - 'a';
				if (prev!=curr && alpha[curr] > 0) {
					group = false;
					break;
				}
				alpha[curr]++;
				prev = curr;
			}
			if (group) {
				cnt++;
			}
		}
		System.out.println(cnt);

		sc.close();
	}
}
