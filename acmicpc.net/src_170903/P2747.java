import java.util.Scanner;

/**
 * 피보나치 수
 * 
 * @author inho.a.choi
 *
 */
public class P2747 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] d = new int[n + 1];
		d[0] = 0;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		System.out.println(d[n]);
		sc.close();
	}
}
