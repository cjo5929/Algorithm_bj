import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, NUM;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQ = new PriorityQueue(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				} else if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				} else {
					return -1;
				}

			}
		});

		for (int i = 0; i < N; i++) {
			NUM = Integer.parseInt(br.readLine());

			if (NUM == 0) {
				if (priorityQ.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(priorityQ.poll()).append("\n");
				}
			} else {
				priorityQ.offer(NUM);
			}
		}

		System.out.println(sb);
	}

}