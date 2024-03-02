import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, R, C, L, cnt;
	static int[][] arr;
	static ArrayList<Point> start_list;
	static boolean[][] visited;
	static int[][][] dist = { {{0}} , {{ 1, -1, 0, 0 }, { 0, 0, 1, -1 } }, { { 1, -1 }, { 0, 0 } }, { { 0, 0 }, { 1, -1 } },
			{ { -1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } }, { { -1, 0 }, { 0, -1 } } };
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			cnt = 1;

			arr = new int[N][M];

			start_list = new ArrayList<Point>();
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			bfs(R, C);
			if(L == 1) cnt = 1;
			
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<Point>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		int time = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();

			while(size-- > 0) {
				Point cur = q.poll();
				int num = arr[cur.x][cur.y];
				
				for(int i = 0; i < dist[num][0].length; i++) {
					int ax = cur.x + dist[num][0][i];
					int ay = cur.y + dist[num][1][i];

//					배열이 안 벗어나고 다음 터널이랑 연결 가능할 경우
					if(check(ax, ay) && possible(dist[num][0][i], dist[num][1][i], arr[ax][ay])) {
						cnt++;
						visited[ax][ay] = true;
						q.add(new Point(ax, ay));
					}
				}
				
			}
			
//			시간 소요 끝나면 나오기
			if(++time >= L) {
				break;
			}
			
		}
		
		
		
	}
	static boolean possible(int ax, int ay, int num) {
		
		if(num == 1) return true;
		
		for(int i = 0; i < dist[num][0].length; i++) {
			int dx = dist[num][0][i];
			int dy = dist[num][1][i];

			if((dx * -1) == ax && (dy * -1) == ay) {
				return true;
			}
		}
		return false;
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < M && !visited[ax][ay] && arr[ax][ay] != 0;
	}

}