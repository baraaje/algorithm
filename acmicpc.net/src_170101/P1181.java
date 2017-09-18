import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class P1181 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1181.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			if (!list.contains(str)) {
				list.add(str);
			}
		}

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length() - s2.length();
			}
		});
		for (String s : list) {
			System.out.println(s);
		}
		sc.close();
	}
}
