import java.util.Scanner;

/**
 * 팩토리얼 0의 개수
 * 
 * @author inho.a.choi
 *
 */
public class P1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int twos = 0;
		int fives = 0;
		for (int i = 1; i <= N; i++) {
			int n = i;
			for (; n % 2 == 0; n /= 2) {
				twos++;
			}
			for (; n % 5 == 0; n /= 5) {
				fives++;
			}
		}
		System.out.println(Math.min(twos, fives));
		sc.close();
	}
}
