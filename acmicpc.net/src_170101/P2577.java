import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 숫자의 개수
 * 
 * @author inho.a.choi
 *
 */
public class P2577 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P2577.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int[] cnts = new int[10];
		int D = A * B * C;
		while (D > 0) {
			cnts[D % 10]++;
			D /= 10;
		}
		for (int i = 0; i <= 9; i++) {
			System.out.println(cnts[i]);
		}
		sc.close();
	}
}