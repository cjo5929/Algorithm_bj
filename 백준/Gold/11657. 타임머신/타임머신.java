
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int start;
	int value;
	int end;

	public Edge(int start, int value, int end) {
		this.start = start;
		this.value = value;
		this.end = end;
	}

}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static Edge[] list;
	static long[] dist;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

		list = new Edge[M + 1];
		dist = new long[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list[i] = new Edge(A, C, B);
		}

		if (belManFord()) {
			sb.append(-1 + "\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == Integer.MAX_VALUE)
					sb.append(-1 + "\n");
				else
					sb.append(dist[i] + "\n");
			}
		}

		System.out.println(sb);

	}

	static boolean belManFord() {
		dist[1] = 0; // 시작 도시 1

//		N - 1번 돌기 => 전체 도시 탐색 1회
		for (int i = 1; i < N; i++) {

//			엣지리스트 확인
			for (int j = 0; j < M; j++) {
				Edge edge = list[j];

//					최단 거리 갱신이 있다면 dist배열에 바꿔주고 update true
				if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > edge.value + dist[edge.start]) {
					dist[edge.end] = edge.value + dist[edge.start];
				}

			}

		}

//		음수사이클 존재 여부 확인을 위해 한 번더 돌리기
//		도시 1번 부터 N번까지
		for (int i = 0; i < M; i++) {
			Edge edge = list[i];

//				최단 거리 갱신이 있다면 dist배열에 바꿔주고 update true
			if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > edge.value + dist[edge.start]) {
				return true;
			}

		}

		return false;

	}

}