import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 단어공부
 * 
 * @author inho.a.choi
 *
 */
public class P1157 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1157.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] alpha = new int[26];
		int max = -1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int x = (c >= 'a') ? c - 'a' : c - 'A';
			alpha[x]++;
			if (max < alpha[x]) {
				max = alpha[x];
			}
		}

		char y = '?';
		for (int i = 0; i < 26; i++) {
			if (alpha[i] == max) {
				if (y != '?') {
					y = '?';
					break;
				}
				y = (char) ('A' + i);
			}
		}

		System.out.println(y);

		sc.close();
	}
}
