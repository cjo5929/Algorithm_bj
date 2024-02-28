import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int M, N, K, result;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] h_dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] h_dy = { -1, 1, -2, 2, 2, -2, 1, -1 };
	static boolean[][][] visited;

	static class Monkey {
		int x, y, cnt, k;

		public Monkey(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}

	}

	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		result = Integer.MAX_VALUE;
		visited = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		

	}

	static void bfs() {
		Queue<Monkey> q = new ArrayDeque<>();
		q.add(new Monkey(0, 0, 0, K));
		visited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Monkey current = q.poll();
			if(current.x == N - 1 && current.y == M - 1) {
				result = current.cnt;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int ax = current.x + dx[i];
				int ay = current.y + dy[i];
				
				if(check(ax, ay) && arr[ax][ay] == 0 && !visited[ax][ay][current.k]) {
					visited[ax][ay][current.k] = true;
					q.add(new Monkey(ax, ay, current.cnt + 1, current.k));
				}
			}
			
			if(current.k > 0) {
				for(int i = 0; i < 8; i++) {
					int ax = current.x + h_dx[i];
					int ay = current.y + h_dy[i];
					
					if(check(ax, ay) && arr[ax][ay] == 0 && !visited[ax][ay][current.k - 1]) {
						visited[ax][ay][current.k - 1] = true;
						q.add(new Monkey(ax, ay, current.cnt + 1, current.k - 1));
					}
				}
			}
		}
		
	}
	
	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < M;
	}

}