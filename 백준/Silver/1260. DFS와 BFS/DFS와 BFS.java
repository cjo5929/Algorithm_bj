import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static ArrayList<Integer>[] list;
	static ArrayList[] graph;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 방향성 : 양방향
			list[a].add(b);
			list[b].add(a);
		}
//		정점 번호가 작은 것 부터 먼저 처리
		for (int n = 1; n <= N; n++) {
			Collections.sort(list[n]);
		}

//	      입력 확인
//		for(ArrayList a : list) {
//			System.out.println(a);
//		}
		boolean[] visited = new boolean[N + 1];
//		visited[V] = true;
		dfs(V, visited);
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}

	static void dfs(int next, boolean[] visited) {
		visited[next] = true;
		sb.append(next).append(" ");
		
		for (int i = 0; i < list[next].size(); i++) {
			
			if (!visited[list[next].get(i)]) {
				dfs(list[next].get(i), visited);

			}
		}

	}

	static void bfs() {
//		1. 준비물
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];

//		2. 초기화
		q.offer(V); // 방문할꺼야
		visited[V] = true;
//	    3. 방문
		while (!q.isEmpty()) {
//			3-1 대장 데려오기
			int next = q.poll();

//			3-2 대장  사용하기
			sb.append(next).append(" ");

//			3-3 미방문한 자식 탐색하기
			for (int i = 0; i < list[next].size(); i++) {
				if (!visited[list[next].get(i)]) {
					q.add(list[next].get(i)); // 방문할꺼야...
					visited[list[next].get(i)] = true;
				}

			}

		}
	}

}