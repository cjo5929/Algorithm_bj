import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, X, K, cnt;
	static ArrayList<Day> projects;

	static class Day implements Comparable<Day> {
		int start, end;

		public Day(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Day o) {
			if (this.start == o.start) {
				return Integer.compare(this.end, o.end) * -1;
			}
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Day [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		projects = new ArrayList<Day>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			a = a * 100;
			c = c * 100;

			projects.add(new Day((a + b), (c + d)));

		}

		Collections.sort(projects);

		int max_end = 0;
		int start = 301;
		int end = 1201;
		int cnt = 0;
		int index = 0;

		while (start < end) {

			boolean flag = false;

			for (int i = index; i < N; i++) {
				Day cur = projects.get(i);

				if (cur.start > start)
					break;

				if (max_end < cur.end) {
					max_end = cur.end;
					flag = true;
					index = i + 1;
				}

			}

			if (flag) {
				start = max_end;
				cnt++;
			} else {
				break;
			}

		}

		if (max_end < end) {
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(cnt);

	}

}