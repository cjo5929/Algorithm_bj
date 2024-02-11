import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, a, b, c;
	static int[] list;
	static int[][] dist;
	static final int INF = 10000001; // 적당히 큰 수로 설정

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N + 1][N + 1];
		
//		거리를 표현한 인접행렬 초기화 
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) {
					dist[i][j] = 0;
				}else {
					dist[i][j] = INF;
				}
			}
		}

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(dist[a][b] > c) dist[a][b] = c;  //입력 받을 때 dist행렬 정보 업데이트 
			
		}
		
		for(int k = 1; k <= N; k++) { // 경유지 노드
			for(int i = 1; i <= N; i++) { // 출발 노드
				for(int j = 1; j <= N; j++) { // 도착 노드 
					if(dist[i][j] > dist[i][k] + dist[k][j]) { // i에서 j로 가는 길보다 i -> k -> j 로 가는 길이 더 적은 비용이 든다면 업데이트
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
				
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(dist[i][j] == INF) sb.append(0 + " ");
				else sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		

	}

}