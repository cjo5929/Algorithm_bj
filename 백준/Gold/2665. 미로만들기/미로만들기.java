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
	static int N, result;
	static int[][] arr;
	static int[][] dist;
	static Queue<Point> q;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] a = st.nextToken().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = a[j] - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}

		}

		bfs(0, 0);
		System.out.println(dist[N - 1][N - 1]);


	}

	static void bfs(int x, int y) {
		q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		dist[x][y] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ax = cur.x + dx[i];
				int ay = cur.y + dy[i];

				if (!check(ax, ay))
					continue;

				if (dist[ax][ay] > dist[cur.x][cur.y]) {
					if (arr[ax][ay] == 1)
						dist[ax][ay] = dist[cur.x][cur.y];
					else {
						dist[ax][ay] = dist[cur.x][cur.y] + 1;
					}
						
					q.offer(new Point(ax, ay));
				}

			}

		}

	}

	static boolean check(int ax, int ay) {
		return (ax >= 0 && ax < N && ay >= 0 && ay < N);
	}

}