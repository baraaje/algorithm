import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 크로아티아 알파벳
 * 
 * @author inho.a.choi
 *
 */
public class P2941 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P2941.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			cnt++;
			char c = str.charAt(i);
			// c, s, z : -, =
			// ㅣ, n : j
			// d : z=, -

			if (i + 1 == str.length()) {
				break;
			}
			if (c == 'c' || c == 's' || c == 'z') {
				c = str.charAt(i + 1);
				if ((c == '-' || c == '=')) {
					i++;
				}
			}
			if (c == 'l' || c == 'n') {
				c = str.charAt(i + 1);
				if (c == 'j') {
					i++;
				}
			}
			if (c == 'd') {
				c = str.charAt(i + 1);
				if (c == '-') {
					i++;
				} else if (c == 'z' && i + 2 < str.length()) {
					c = str.charAt(i + 2);
					if (c == '=') {
						i += 2;
					}
				}
			}
		}
		System.out.println(cnt);

		sc.close();
	}
}
