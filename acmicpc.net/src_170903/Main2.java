import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 
 * 
 * @author inho.a.choi
 *
 */
public class Main2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + Main2.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);


		sc.close();
	}
}
