import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int l, w, result, time;
	static char[][] arr;
	static boolean[][] visited;
	static ArrayDeque<Land> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static class Land {
		int x, y, time;

		Land(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = new char[l][w];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < w; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 'L') {
					result = Math.max(bfs(i, j, 0), result);
				}
			}
		}

		System.out.println(result);
	}

	static int bfs(int x, int y, int time) {
		q = new ArrayDeque<>();
		visited = new boolean[l][w];
		q.offer(new Land(x, y, time));
		visited[x][y] = true;
		int temp = 0;

		while (!q.isEmpty()) {
			Land cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ax = cur.x + dx[i];
				int ay = cur.y + dy[i];

				if (check(ax, ay) && arr[ax][ay] != 'W') {
					visited[ax][ay] = true;
					q.offer(new Land(ax, ay, cur.time + 1));
					temp = Math.max(temp, cur.time + 1);
				}
			}
		}

		return temp;
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < l && ay >= 0 && ay < w && !visited[ax][ay];
	}
}