/**
 * @author 강민서
 * @date 2024.02.22
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV_mSnmKUckDFAWb&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0219%EC%A3%BC&problemBoxCnt=3&probBoxId=AY3JcG16dgMDFAXh
 * @keyword_solution  
 *
 * 1. 에지리스트로 구현하고 유니온 파인트 배열 초기화
 * 2. 가중치 기준으로 오름차순 정렬
 * 3. 가중치가 가장 낮은 에지부터 연결 시도 
 *
 * @input V(1≤V≤100,000)와 간선의 개수 E(1≤E≤200,000) C는 음수일 수도 있으며, 절대값이 1,000,000 => 가중치 합을 int로 하면 오버플로 날 수도 있음 long으로 출력
 * @output long으로 출력
 * @time_complex  113,892 kb 2,518 ms
 * @perf O(ElogE)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, V, E, edge;
	static long result;
	static int[] parent;
	static Queue<Edge> q;

//	에지리스트
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int value;

		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

//		가중치 오름차순 
		public int compareTo(Edge o) {

			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V + 1];
			q = new PriorityQueue<Edge>();

//			1. 에지리스트로 구현하고 유니온 파인트 배열 초기화
			for (int i = 0; i < V + 1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				q.add(new Edge(a, b, c));
			}
			
			edge = 0;
			result = 0;

//			MST를 만족하기 위해서는 에지 수가 최대 V - 1개
			while (edge < V - 1) {
				Edge cur = q.poll();

//			    3. 가중치가 가장 낮은 에지부터 연결 시도 => 대표노드가 서로 다를 경우! , 만약 같다면 사이클이 형성됨 
				if (find(cur.start) != find(cur.end)) {
					union(cur.start, cur.end);
					result += cur.value;
					edge++;
				}
			}

			sb.append(result + "\n");
		}

		System.out.println(sb);
	}

//	union 연산 
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

//	find 연산 => 사이클 여부 확인
	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
}