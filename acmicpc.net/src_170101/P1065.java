import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 셀프 넘버
 * 
 * @author inho.a.choi
 *
 */
public class P1065 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1065.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			System.out.println(i + " : " + isHan(i));
			if (isHan(i)) {
				cnt++;
			}
		}

		System.out.println(cnt);

		sc.close();
	}

	private static boolean isHan(int n) {
		if (n < 100) {
			return true;
		}
		// 1의 자리수
		int a = n % 10;
		n /= 10;
		// 10의 자리수
		int b = n % 10;
		n /= 10;
		int d = b - a;
		a = b;
		while (n > 0) {
			b = n % 10;
			if (b - a != d) {
				return false;
			}
			n /= 10;
			a = b;
		}
		return true;
	}

}
