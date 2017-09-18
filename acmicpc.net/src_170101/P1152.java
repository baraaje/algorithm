import java.io.FileInputStream;
import java.util.Scanner;

public class P1152 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1152.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		while (sc.hasNext()) {
			String str = sc.next();
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}