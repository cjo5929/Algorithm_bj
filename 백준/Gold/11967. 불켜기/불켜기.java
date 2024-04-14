import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, result;
	static ArrayList<Room>[][] arr;
	static ArrayDeque<Room> q;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static boolean[][] lights;

	static class Room {
		int x, y;

		public Room(int x, int y) {
			super();
			this.x = x;
			this.y = y;

		}

	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1][n + 1];
		lights = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				arr[i][j] = new ArrayList<Room>();
			}

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]
					.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		bfs();

		System.out.println(result + 1);

	}

	static void bfs() {
		q = new ArrayDeque<>();
		q.add(new Room(1, 1));
		visited[1][1] = true;
		lights[1][1] = true;

		boolean flag;

		while (!q.isEmpty()) {
			Room cur = q.poll();

			if (!arr[cur.x][cur.y].isEmpty()) {

				visited = new boolean[n + 1][n + 1];
				visited[cur.x][cur.y] = true;

				for (Room r : arr[cur.x][cur.y]) {

					if (!lights[r.x][r.y]) {
						lights[r.x][r.y] = true;
						result++;
					}
				}
				
				arr[cur.x][cur.y].clear();
			}
			
			for (int i = 0; i < 4; i++) {
				int ax = cur.x + dx[i];
				int ay = cur.y + dy[i];
				
				if (check(ax, ay) && !visited[ax][ay] && lights[ax][ay]) {
					q.offer(new Room(ax, ay));
					visited[ax][ay] = true;
				}
			}

		}

	}

	static boolean check(int ax, int ay) {
		return ax >= 1 && ax <= n && ay >= 1 && ay <= n;
	}
}