import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 다이아몬드 광산
 * 
 * @author inho.a.choi
 *
 */
public class P1028 {
	private static int VALUE = 0;
	private static int LEFT = 1;
	private static int RIGHT = 2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res_170101/" + P1028.class.getCanonicalName() + ".txt"));
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();

		int[][][] d = new int[R][C][3]; // 0 : 값(0 또는 1), 1 : 왼쪽 사선 길이, 2 : 오른쪽 사선 길이
		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < C; j++) {
				d[i][j][VALUE] = (int) (line.charAt(j) - '0');
			}
		}

		// 1. 모든 위치에서 왼쪽, 오른쪽 아래 방향으로의 사선 길이를 구한다.
		// 2. 해당 위치에서 채굴 가능한 최대 다이어몬드 크기를 구한다.

		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (d[i][j][0] == 1) {
					if (i == R - 1) {
						d[i][j][LEFT] = d[i][j][RIGHT] = 1;
					} else {
						if (j == 0) {
							d[i][j][LEFT] = 1;
							d[i][j][RIGHT] = d[i + 1][j + 1][RIGHT] + 1;
						} else if (j == C - 1) {
							d[i][j][LEFT] = d[i + 1][j - 1][LEFT] + 1;
							d[i][j][RIGHT] = 1;
						} else {
							d[i][j][LEFT] = d[i + 1][j - 1][LEFT] + 1;
							d[i][j][RIGHT] = d[i + 1][j + 1][RIGHT] + 1;
						}
					}
				}
			}
		}

		// 각 위치에 대해 채굴 가능한 다이어몬드 최대 크기 판단
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int csize = Math.min(d[i][j][LEFT], d[i][j][RIGHT]);
				int dsize = csize;
				if (csize > 1) {
					while (csize > 1) {
						int tmp = csize - 1;
						if (d[i + tmp][j - tmp][RIGHT] >= csize && d[i + tmp][j + tmp][LEFT] >= csize) {
							dsize = csize;
							break;
						}
						csize--;
					}
				}

				if (ans < dsize) {
					ans = dsize;
				}
			}
		}
		
		System.out.println(ans);
	}
}
