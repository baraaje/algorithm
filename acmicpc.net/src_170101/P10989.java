import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 수 정렬하기 3
 * 
 * @author inho.a.choi
 *
 */
public class P10989 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P10989.class.getCanonicalName() + ".txt")));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		int[] data = new int[N + 1];
		int[] count = new int[10001];

		// date read and count
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(reader.readLine());
			count[data[i]]++;
		}
		// accumulated sum
		for (int i = 1; i <= 10000; i++) {
			count[i] += count[i - 1];
		}
		// sort
		int[] sorted = new int[N + 1];
		for (int i = N; i > 0; i--) {
			sorted[count[data[i]]] = data[i];
			count[data[i]]--;
		}

		// 출력
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			writer.write(sorted[i] + "\n");
		}
		writer.flush();
	}
}
