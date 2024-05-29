import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int[][] arr;
	static ArrayList<Member> list;

	static class Member implements Comparable<Member> {
		int num, cnt;

		public Member(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Member o) {
			if (this.cnt == o.cnt) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.cnt, o.cnt);
		}

		@Override
		public String toString() {
			return "Member [num=" + num + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];
		list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {

					arr[i][j] = 1000000;
				}
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1)
				break;

			arr[a][b] = arr[b][a] = 1;

		}

//		플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int min_score = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int score = 0;
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] != 1000000) {
					score = Math.max(score, arr[i][j]);

				}
			}
			min_score = Math.min(min_score, score);
			list.add(new Member(i, score));
		}
		Collections.sort(list);

		sb.append(min_score + " ");

		int result_cnt = 0;

		for (Member user : list) {
			if (user.cnt == min_score) {
				result_cnt++;
			}
		}
		sb.append(result_cnt + "\n");

		for (Member user : list) {
			if (user.cnt == min_score) {
				sb.append(user.num + " ");
			} else
				break;

		}

		System.out.println(sb);
	}

}