import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 피보나치수 3
 * 
 * @author inho.a.choi
 *
 */
public class P1749 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1749.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int mod = 1000000;
		int p = mod / 10 * 15;
		int[] fibo = new int[p + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= p; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
			fibo[i] %= mod;
		}
		long n = sc.nextLong();
		System.out.println(fibo[(int) (n % p)]);

		sc.close();
	}
}
