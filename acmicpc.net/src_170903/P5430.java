import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * AC
 * 
 * @author inho.a.choi
 *
 */
public class P5430 {
	static int MAX = 100000;
	static int[] q = new int[MAX];
	static int first;
	static int last;
	static boolean forward = true;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170903/" + "I.in")));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			first = last = 0;
			forward = true;
			
			String cmd = sc.next();
			int n = sc.nextInt();
			String str = sc.next();
			if (n > 0) {
				int begin = 1;
				int end = 1;
				for (int i = 1; i < str.length() - 1; i++) {
					if (str.charAt(i) == ',') {
						String numStr = str.substring(begin, end);
						offerLast(Integer.parseInt(numStr));
						begin = end = i + 1;
					} else if (i == str.length() - 2) {
						String numStr = str.substring(begin, end + 1);
						offerLast(Integer.parseInt(numStr));
					} else {
						end++;
					}
				}
			}

			boolean e = false;
			for (int i = 0; i < cmd.length(); i++) {
				char c = cmd.charAt(i);
				if (c == 'R') {
					reverse();
				} else if (c == 'D') {
					if (isEmpty()) {
						e = true;
						break;
					} else {
						if (forward) {
							pollFirst();
						} else {
							pollLast();
						}
					}
				}
			}
			if (e) {
				System.out.println("error");
			} else {
				StringBuffer sb = new StringBuffer();
				sb.append("[");
				if (!isEmpty()) {
					sb.append(forward ? pollFirst() : pollLast());
				}
				while (!isEmpty()) {
					sb.append("," + (forward ? pollFirst() : pollLast()));
				}
				sb.append("]");

				System.out.println(sb.toString());
			}

		}

		sc.close();
	}

	private static int pollLast() {
		return q[--last];
	}

	private static void reverse() {
		/*
		 * int half = (last - first) / 2;
		 * for (int i = 0; i < half; i++) {
		 * int temp = q[first + i];
		 * q[first + i] = q[last - i - 1];
		 * q[last - i - 1] = temp;
		 * }
		 */
		forward = !forward;
	}

	private static Object pollFirst() {
		return q[first++];
	}

	private static boolean isEmpty() {
		return first == last;
	}

	private static void offerLast(int n) {
		q[last++] = n;
	}
}
