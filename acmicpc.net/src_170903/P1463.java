import java.util.Scanner;

/**
 * 1로 만들기
 * 
 * @author inho.a.choi
 *
 */
public class P1463 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println(f(sc.nextInt()));
		sc.close();
	}

	private static int f(int n) {
		if (n < 2) {
			return 0;
		}
		int a = f(n / 2) + n % 2 + 1;
		int b = f(n / 3) + n % 3 + 1;
		return Math.min(a, b);
	}
}
