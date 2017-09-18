import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * ACM 호텔
 * 
 * @author inho.a.choi
 *
 */
public class P10250 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P10250.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			int a = (N % H == 0) ? H : N % H; // 나머지
			int b = N / H + ((N % H == 0) ? 0 : 1); // 몫 + 1 -> 호수
			System.out.println(a * 100 + b);
		}

		sc.close();
	}
}
