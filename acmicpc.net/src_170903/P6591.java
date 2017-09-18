import java.util.Scanner;

/**
 * 이항 쇼다운
 * 
 * @author inho.a.choi
 *
 */
public class P6591 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			if (n == 0 && m == 0) {
				break;
			}

			if (m > n - m) {
				m = n - m;
			}

			long result = 1;
			for (int i = 1; i <= m; i++) {
				result *= n--;
				result /= i;
			}
			System.out.println(result);
		}
		sc.close();
	}
}
