import java.util.Scanner;

/**
 * 팩토리얼
 * 
 * @author inho.a.choi
 *
 */
public class P10872 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long ans = 1;
		for (int i = 2; i <= N; i++) {
			ans *= i;
		}
		System.out.println(ans);

		sc.close();
	}
}
