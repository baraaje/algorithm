import java.io.FileInputStream;
import java.util.Scanner;

public class P1110 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1110.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i <= 99; i++) {
			int cnt = 0;
			int curr = i;
			int next = -1;
			while (next != i) {
				int a = curr / 10;
				int b = curr % 10;
				next = b * 10 + (a + b) % 10;
				cnt++;
				curr = next;
			}
			System.out.println(i + " : " + cnt);
		}
		sc.close();

	}
}