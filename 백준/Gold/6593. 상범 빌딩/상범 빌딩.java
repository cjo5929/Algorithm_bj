import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int l, r, c;
	static char[][][] arr;
	static boolean[][][] visited;
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, -1, 0, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static ArrayDeque<int[]> q;

	public static void main(String[] args) throws IOException {

		while (true) {

			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (l == 0 && r == 0 && c == 0) {
				System.out.println(sb.toString());
				return;
			}

			arr = new char[l][r][c];

			int start_x = 0;
			int start_y = 0;
			int start_z = 0;

			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						arr[i][j][k] = str.charAt(k);

						if (arr[i][j][k] == 'S') {
							start_z = i;
							start_x = j;
							start_y = k;
							arr[i][j][k] = '.';
						}
					}
				}
				br.readLine();
			}

			bfs(start_z, start_x, start_y);


		}
	}

	static void bfs(int start_z, int start_x, int start_y) {
		visited = new boolean[l][r][c];
		q = new ArrayDeque<>();
		q.offer(new int[]{start_z, start_x, start_y, 0});
		visited[start_z][start_x][start_y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if(arr[cur[0]][cur[1]][cur[2]] == 'E') {
				sb.append("Escaped in ").append(cur[3]).append(" minute(s).\n");
				return;
			}


			for (int i = 0; i < 6; i++) {
				int z = cur[0] + dz[i];
				int x = cur[1] + dx[i];
				int y = cur[2] + dy[i];

				if(check(z, x, y) && !visited[z][x][y] && arr[z][x][y] != '#') {

					visited[z][x][y] = true;
					q.offer(new int[]{z, x, y, cur[3] + 1});


				}
			}
		}
		sb.append("Trapped!\n");

	}

	static boolean check(int z, int x, int y) {
		return z >= 0 && z < l && x >= 0 && x < r && y >= 0 && y < c;
	}
}