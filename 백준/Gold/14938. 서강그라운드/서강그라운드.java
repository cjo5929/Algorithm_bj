import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

	int number;
	int distance;
	int item;

	public Edge(int number, int distance, int item) {
		this.number = number;
		this.distance = distance;
		this.item = item;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.distance > o.distance)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "Edge [number=" + number + ", dist=" + distance + ", item=" + item + "]";
	}

}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, R, X, A, B, result, max_result;
	static PriorityQueue<Edge> q;
	static ArrayList<Edge>[] maps;
	static int[] dist_arr, items;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
//		입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

//		변수 초기화
		items = new int[N + 1];
		maps = new ArrayList[N + 1];
		dist_arr = new int[N + 1];
		visited = new boolean[N + 1];
		dist_arr = new int[N + 1];
		max_result = 0;
		for (int i = 0; i <= N; i++) {
			maps[i] = new ArrayList<Edge>();
		}

		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

//		입력 => 인접리스트 생성
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			maps[s].add(new Edge(n, d, items[n]));
			maps[n].add(new Edge(s, d, items[s]));

		}

//		다익스트라 지역 번호 N번 마다 돌리기 => 출발지 계속 바꿔서 다익스트라...
		for (int i = 1; i <= N; i++) {
//			거리 맥스로 초기화
			
			for (int j = 0; j <= N; j++) {
				dist_arr[j] = Integer.MAX_VALUE;
			}

			dist_arr[i] = 0; // 자기도시는 거리가 0
			dijkstra(i);
			
			result = 0; // 출발지 별 아이템 개수를 저장 할 변수 초기화
			for (int j = 1; j <= N; j++) {  // 각 최단거리가 저장 된 dist_arr에서 수색범위 만큼 갈 수 있는 지역 고르기
				if(dist_arr[j] <= M) {
					result += items[j];
				}
			}
			
			
//			System.out.println(result);
			max_result = Math.max(max_result, result);
			
		}
		
		System.out.println(max_result);

	}
//  다익스트라 알고리즘 출발지로 부터 최단거리 계산 => 
 	static void dijkstra(int x) {
		q = new PriorityQueue<>();
		q.offer(new Edge(x, 0, items[x]));

		while (!q.isEmpty()) {
			Edge current = q.poll();
			int num = current.number;

			for (int i = 0; i < maps[num].size(); i++) {
				Edge next = maps[num].get(i);
				int next_num = next.number;
				int next_dist = next.distance;

				if (dist_arr[next_num] > dist_arr[num] + next_dist) {
					dist_arr[next_num] = dist_arr[num] + next_dist;
					q.offer(new Edge(next_num, dist_arr[next_num], items[next_num]));

				}

			}

		}

	}

}