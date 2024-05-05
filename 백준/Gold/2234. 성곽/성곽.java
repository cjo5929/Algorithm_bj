import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, room_cnt, max_room, result;
	static int[][] arr;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[][] visited;
	static int[][] arr_room;
	static Map<Integer, Integer> maps = new HashMap<>();
	static ArrayDeque<Point> q;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		arr_room = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int room = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {

					room = bfs(i, j);
					room_cnt++;
					maps.put(room_cnt, room);

					max_room = Math.max(max_room, room);
				}

			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(arr_room[ax]);
//			}
//
//		}

		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					max_bfs(i, j);
				}
			}

		}
		System.out.println(room_cnt);
		System.out.println(max_room);
		System.out.println(result);

	}

//	방 갯수와 가장 넓은 방 크기 구하는 bfs
	static int bfs(int x, int y) {
		q = new ArrayDeque<Point>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		int room = 0;
		arr_room[x][y] = room_cnt + 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			arr_room[cur.x][cur.y] = room_cnt + 1;
			room++;

			for (int i = 0; i < 4; i++) {
				int ax = cur.x + dx[i];
				int ay = cur.y + dy[i];

				if (check(ax, ay) && (arr[cur.x][cur.y] & (1 << i)) == 0) {

					q.offer(new Point(ax, ay));
					visited[ax][ay] = true;

				}
			}
		}

		return room;
	}

// 하나의 벽을 제거하고 가장 큰 방 넓이 구하는 bfs
	static void max_bfs(int x, int y) {
		q = new ArrayDeque<Point>();
		q.offer(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ax = cur.x + dx[i];
				int ay = cur.y + dy[i];

				if (check(ax, ay)) {

					if (arr_room[cur.x][cur.y] != arr_room[ax][ay]) {
						result = Math.max(result, maps.get(arr_room[ax][ay]) + maps.get(arr_room[cur.x][cur.y]));
					}
					q.offer(new Point(ax, ay));
					visited[ax][ay] = true;

				}
			}
		}
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < n && ay >= 0 && ay < m && !visited[ax][ay];
	}

}