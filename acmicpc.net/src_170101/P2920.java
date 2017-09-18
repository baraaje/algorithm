import java.io.FileInputStream;
import java.util.Scanner;

public class P2920 {
	static int ASC = 1;
	static int DES = -1;
	static int MIXED = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P2920.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int state = (x == 1) ? ASC : ((x == 8) ? DES : MIXED);
		if (state != MIXED) {
			for (int i = 2; i <= 8; i++) {
				int y = sc.nextInt();
				if (x < y && state == DES) {
					state = MIXED;
					break;
				}
				if (x > y && state == ASC) {
					state = MIXED;
					break;
				}
				x = y;
			}
		}
		System.out.println(state == ASC ? "ascending" : (state == DES ? "descending" : "mixed"));
		sc.close();
	}
}