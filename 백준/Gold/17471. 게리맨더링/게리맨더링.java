import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int N, result;
	static int[] arr, answer;
	static ArrayList<Integer>[] list;

	static ArrayList<Integer> powerSet_1;
	static ArrayList<Integer> powerSet_2;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		result = Integer.MAX_VALUE;
		answer = new int[N];
		
		for(int i = 0; i < N; i++) {
			answer[i] = i + 1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
//		powerSet(1, visited);
		makePowerSet();

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		} else {
			System.out.println(result);
		}

	}

	static void powerSet(int depth, boolean[] choosed) {

		if (depth == N + 1) {

			int cnt = 0;
			powerSet_1 = new ArrayList<Integer>();
			powerSet_2 = new ArrayList<Integer>();

			for (int i = 1; i <= N; i++) {
				if (choosed[i])
					powerSet_1.add(i);
				else
					powerSet_2.add(i);
			}

			if (!powerSet_1.isEmpty() && !powerSet_2.isEmpty()) {
				if (check(powerSet_1) && check(powerSet_2)) {

					cnt = Math.abs(cnt_result(powerSet_1) - cnt_result(powerSet_2));
					result = Math.min(cnt, result);
				}

			}

			return;
		}

		choosed[depth] = true;
		powerSet(depth + 1, choosed);
		choosed[depth] = false;
		powerSet(depth + 1, choosed);
	}

	static boolean check(ArrayList<Integer> ps) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] q_visited = new boolean[N + 1];
		q.add(ps.get(0));
		q_visited[ps.get(0)] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int current = q.poll();
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				if (!q_visited[next] && ps.contains(next)) {
					cnt++;
					q_visited[next] = true;
					q.offer(next);
				}
			}
		}
		if (cnt == ps.size()) {
			return true;
		}

		return false;

	}

	static int cnt_result(ArrayList<Integer> ps) {
		int cnt = 0;
		for (int index : ps) {
			cnt += arr[index];
		}

		return cnt;
	}

	static void makePowerSet() {
		for (int i = 0; i < (1 << N - 1); i++) {
			powerSet_1 = new ArrayList<Integer>();
			powerSet_2 = new ArrayList<Integer>();
			
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					powerSet_1.add(answer[j]);
				} else {
					powerSet_2.add(answer[j]);
				}
			}
			int cnt = 0;
			if (!powerSet_1.isEmpty() && !powerSet_2.isEmpty()) {
				if (check(powerSet_1) && check(powerSet_2)) {

					cnt = Math.abs(cnt_result(powerSet_1) - cnt_result(powerSet_2));
					result = Math.min(cnt, result);
				}

			}else continue;
			
		}

	}

}