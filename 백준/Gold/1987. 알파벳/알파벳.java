import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] visited = new boolean[26];
	static int R, C, result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		result = 0;
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++ ) {
				arr[i][j] = str.charAt(j) -'A';
			}
			
		}
		if(R == 1 && C == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
		dfs(0, 0, 0);
		
		System.out.println(result);
		
	}
	
	static void dfs(int x, int y, int cnt) {
		if(visited[arr[x][y]]) {
			result = Math.max(result, cnt);
			return;
		}else {

			visited[arr[x][y]] = true;
			for(int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				
				if(check(ax, ay)) {
					dfs(ax, ay, cnt + 1);
				}
			}
			
			visited[arr[x][y]] = false;
		}
		
		

		
		
	}
	
	static boolean check(int ax, int ay) {
		if(ax >= 0 && ax < R && ay >= 0 && ay < C) return true;
		return false;
	}

}