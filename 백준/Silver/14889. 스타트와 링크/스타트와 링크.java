import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, result;
	static int T, r;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		result = Integer.MAX_VALUE;
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
		dfs(0, 0);
		sb.append(result);
		System.out.println(sb);
	}
	
	static void dfs(int depth, int start) {
		if(depth == N / 2) {
			
			cal();
			return;
		}
		
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			dfs(depth + 1, i + 1);
			visited[i] = false;
		}

	}
	
	static void cal() {
		int start = 0;
		int link = 0;
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(visited[i] && visited[j]) {
					start += arr[i][j] + arr[j][i];
				}else if(!visited[i] && !visited[j]) {
					link += arr[i][j] + arr[j][i];
				}
			}
		}
		
		result = Math.min(result, Math.abs(start - link));
	}

}