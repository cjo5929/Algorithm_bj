/**
 * @author 강민서
 * @date 2024.02.22
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV15B1cKAKwCFAYD&probBoxId=AY3JcG16dgMDFAXh&type=PROBLEM&problemBoxTitle=0219%EC%A3%BC&problemBoxCnt=3
 * @keyword_solution  연락을 시작하는 당번인 2번은 연락 가능한 7번과 15번에 동시에 연락을 취한다
 * => 연결된 자식이 있으면 동시에 전화하므로 bfs를 통해서 연결 된 노드 탐색
 * => 동시에 하므로 q 사이즈를 저장해 같은 depth들 확인
 * => 모든 결과를 result list에 담고 depth순으로 오름차순 정렬 같으면 번호로 오름차순 정렬 후 가장 마지막꺼 출력
 * @input 번호는 1이상 100이하, 연락 인원은 최대 100명 => 값이 크지 않아 전체 탐색 가능 
 * @output swea 방식으로 출력
 * @time_complex  19,336 kb 116 ms
 * @perf O(N^2)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, start;
	static int[] parent;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q;
	static boolean[] visited;
	static ArrayList<Edge> result;

//	에지리스트
	static class Edge implements Comparable<Edge> {
		int x;
		int depth;

		public Edge(int x, int depth) {
			this.x = x;
			this.depth = depth;

		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", depth=" + depth + "]";
		}

		@Override
		public int compareTo(Edge o) {
			if (this.depth == o.depth) {
				return Integer.compare(this.x, o.x);
			}
			// TODO Auto-generated method stub
			return Integer.compare(this.depth, o.depth);
		}

	}

	public static void main(String[] args) throws IOException {
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			visited = new boolean[101];
			result = new ArrayList<>();

			for (int i = 0; i < 101; i++) {
				list[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list[a].add(b);

			}

			bfs(start);

			Collections.sort(result);
			int size = result.size();
			sb.append(result.get(size - 1).x).append("\n");

		}

		System.out.println(sb.toString().trim());

	}

	static void bfs(int x) {
		q = new ArrayDeque<Integer>();
		q.add(x);
		visited[x] = true;
		int depth = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			depth++;

			while (size-- > 0) {

				int current = q.poll();

				for (int i = 0; i < list[current].size(); i++) {
					int next = list[current].get(i);
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
						result.add(new Edge(next, depth));
					}

				}

			}
		}
	}

}