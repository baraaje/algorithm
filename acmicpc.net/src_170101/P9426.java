import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 중앙값 측정
 * 
 * @author inho.a.choi
 *
 */
public class P9426 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res_170101/" + P9426.class.getCanonicalName() + ".txt")));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] data = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}

		// Max Heap, Min Heap을 만들고
		// k가 짝수면
		// max heap size = min heap size = k / 2
		// k가 홀수면
		// max heazp size = k / 2, min heap size = k/2+1 로 만든다

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

		// 처음 K개까지로 Q를 초기화
		for (int i = 1; i <= K; i++) {
			int a = data[i];
			if (minHeap.size() == 0 || minHeap.peek() > a) {
				maxHeap.add(a);
			} else {
				minHeap.add(a);
			}
			if (maxHeap.size() >= minHeap.size()) {
				minHeap.add(maxHeap.poll());
			}
			if (minHeap.size() - maxHeap.size() > 2) {
				maxHeap.add(minHeap.poll());
			}
		}
		// System.out.printf("init : %s %s\n", maxHeap, minHeap);
		long sum = minHeap.peek();

		for (int i = K + 1; i <= N; i++) {
			int a = data[i];
			int b = data[i - K];

			if (!minHeap.remove(b)) {
				maxHeap.remove(b);
			}
			// System.out.printf("remove %d : %s %s\n", b, maxHeap, minHeap);

			if (minHeap.size() == 0 || minHeap.peek() > a) {
				maxHeap.add(a);
			} else {
				minHeap.add(a);
			}
			// System.out.printf("add %d : %s %s\n", a, maxHeap, minHeap);

			if (maxHeap.size() >= minHeap.size()) {
				minHeap.add(maxHeap.poll());
			}
			if (minHeap.size() - maxHeap.size() > 2) {
				maxHeap.add(minHeap.poll());
			}
			// System.out.printf("balacing : %s %s\n", maxHeap, minHeap);
			sum += minHeap.peek();
		}
		System.out.println(sum);
	}
}
