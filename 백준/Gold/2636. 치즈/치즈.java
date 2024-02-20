import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, result_cnt, time;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> q;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = true;
		int Fcnt = cnt();
		while (true) { 
			time++;
//			외벽 치즈 탐색
			bfs(0, 0);

//			visited 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}

//			2로 바뀐 치즈 없애기(가장 바깥 치즈)
			remove_cheese();

//			치즈 수 세기
			int cnt = cnt();

			if (cnt == 0)
				break;

//			다 녹기 전 치즈저장
			result_cnt = cnt;
		}
		
		sb.append(time + "\n");
		
//		1시간만에 치즈가 없어지면 
		if(time <= 1) {
			sb.append(Fcnt);
		}else {
			sb.append(result_cnt);
		}

		

		System.out.println(sb);
	} 

//	0,0 부터 전체탐색 1을 만나면 2로 변경
	static void bfs(int x, int y) {
		q = new ArrayDeque<>();
		q.offer(new Point(x, y));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ax = cur.x + dx[i];
				int ay = cur.y + dy[i];

				if (check(ax, ay)) {
					if (arr[ax][ay] == 1) {
						arr[ax][ay] = 2;
					} else if (arr[ax][ay] == 0) {
						visited[ax][ay] = true;
						q.add(new Point(ax, ay));
					}

				}
			}

		}
	}

//	2를 1로 변경
	static void remove_cheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 2)
					arr[i][j] = 0;
			}
		}
	}

//	치즈 세기
	static int cnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1)
					cnt++;
			}
		}

		return cnt;
	}

	static boolean check(int ax, int ay) {
		return (ax >= 0 && ax < N && ay >= 0 && ay < M && !visited[ax][ay]);
	}

}