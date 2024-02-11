import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
	int vertex;
	int value;

	public Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Edge>[] list;
	static long[] dist;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

		list = new ArrayList[N + 1];
		dist = new long[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list[A].add(new Edge(B, C));
		}
		
		if(belManFord()) {
			sb.append(-1 + "\n");
		}else {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == Integer.MAX_VALUE) sb.append(-1 + "\n");
				else sb.append(dist[i] + "\n");
			}
		}
		
		System.out.println(sb);

	}

	static boolean belManFord() {
		dist[1] = 0; // 시작 도시 1
		boolean update = false;

//		N - 1번 돌기 => 전체 도시 탐색 1회
		for (int i = 1; i < N; i++) {
			update = false; // dist 값이 변경되면 true로

//			도시 1번 부터 N번까지
			for (int j = 1; j <= N; j++) {
				for (Edge edge : list[j]) {
					if (dist[j] == Integer.MAX_VALUE)
						break;

//					최단 거리 갱신이 있다면 dist배열에 바꿔주고 update true
					if (dist[edge.vertex] > edge.value + dist[j]) {
						dist[edge.vertex] = edge.value + dist[j];
						update = true;
					}

				}

			}
			

		}
		
//		음수사이클 존재 여부 확인을 위해 한 번더 돌리기
		if(update) {
			for(int i = 1; i <= N; i++) {
				for(Edge edge : list[i]) {
					
					if (dist[i] == Integer.MAX_VALUE)
						break;

//					값 변화가 있다면 음수사이클 존재
					if (dist[edge.vertex] > edge.value + dist[i]) {
						dist[edge.vertex] = edge.value + dist[i];
						return true;
					}
				}
			}
			
		}

		return false;

	}

}