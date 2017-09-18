import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 소트인사이드
 * 
 * @author inho.a.choi
 *
 */
public class P1427 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P1427.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		long N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (; N > 0; N /= 10) {
			arr.add((int) (N % 10));
		}
		Collections.sort(arr, Collections.reverseOrder());

		for (int a : arr) {
			System.out.print(a);
		}
		System.out.println();
		sc.close();
	}
}
