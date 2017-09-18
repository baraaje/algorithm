import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 패션왕 신해빈
 * 
 * @author inho.a.choi
 *
 */
public class P9375 {
	private static Map<String, Set<String>> map;
	private static int sum;
	private static int[] sizes;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + P9375.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int n = sc.nextInt();
			map = new HashMap<String, Set<String>>();
			for (int i = 1; i <= n; i++) {
				String v = sc.next();
				String k = sc.next();
				if (map.containsKey(k)) {
					Set<String> s = map.get(k);
					s.add(v);
				} else {
					Set<String> s = new HashSet<String>();
					s.add(v);
					map.put(k, s);
				}
			}

			int sizeIdx = 0;
			sizes = new int[map.size()];
			for (Set<String> s : map.values()) {
				sizes[sizeIdx++] = s.size();
			}

			sum = 0;
			for (int i = 1; i <= n; i++) {
				int[] choices = new int[i];
				combi(choices, 0, map.size(), i, 0);
			}
			System.out.println(sum);
		}

		sc.close();
	}

	private static void combi(int[] choices, int index, int n, int k, int target) {
		if (k == 0) {
			choiceCloth(choices, index);
		} else if (target == n) {
			return;
		} else {
			choices[index] = target;
			combi(choices, index + 1, n, k - 1, target + 1);
			combi(choices, index, n, k, target + 1);
		}
	}

	private static void choiceCloth(int[] choices, int index) {
		int sub = 1;
		for (int i = 0; i < index; i++) {
			sub *= sizes[choices[i]];
		}
		sum += sub;
	}
}
