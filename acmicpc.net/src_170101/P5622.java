import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 다이얼
 * 
 * @author inho.a.choi
 *
 */
public class P5622 {
	static int[] map = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P5622.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += map[str.charAt(i) - 'A'] + 1;
		}
		System.out.println(sum);
		sc.close();
	}
}
