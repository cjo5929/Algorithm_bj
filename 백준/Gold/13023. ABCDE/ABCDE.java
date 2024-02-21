/**
 * @author 강민서
 * @date 2024.02.21
 * @link https://www.acmicpc.net/problem/13023
 * @keyword_solution  친구 관계를 가진 사람 A, B, C, D, E가 존재하는지
 * => dfs로 번호마다 탐색하여 depth 5가 되는 즉, 관계가 5가 되는 번호가 있는지 탐색
 * @input  N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)
 * @output 1 or 0
 * @time_complex  O(N)
 * @perf 19808 288
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean flag;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		visited = new boolean[N];
		flag = false;

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];

			dfs(i, 0);

			if (flag) { // flag를 true로 하고나왔다면 끝 
				System.out.println(1);
				System.exit(0);
			}

		}

		System.out.println(0);
	}

	static void dfs(int start, int depth) {
		if (depth == 4) { // depth가 4일때 나옴(0부터 시작했으므로)
			flag = true;
			return;
		}

		visited[start] = true; // 방문체크 

		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			if (!visited[next]) {
				dfs(next, depth + 1);
			}

		}

		visited[start] = false; // 다른 인덱스에서도 다 탐색해야 하므로 재귀에서 나오면 다시 FALSE
	}

}