import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == 1) {
				deque.addFirst(i);
			} else if (num == 2) {
				int top = deque.removeFirst();
				deque.addFirst(i);
				deque.addFirst(top);
			} else {
				deque.addLast(i);
			}
		}

		// 최종적으로 Deque에 있는 카드들을 순서대로 StringBuilder에 추가
		StringBuilder sb = new StringBuilder();
		while (deque.size() != 0) {
			sb.append(deque.removeFirst() + " ");
		}

		// 결과 출력
		System.out.println(sb);
	}

}