import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, start_x, start_y, result, max_result;
	static int[][] arr;
	static ArrayList<Point> start_list;
	static boolean[][] visited;
	static boolean[] dessert;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			start_list = new ArrayList<Point>();
			visited = new boolean[N][N];
			max_result = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (i < (N - 2) && j != 0 && j < (N - 1)) {
						start_list.add(new Point(i, j));
					}
				}
			}

			for (Point cur : start_list) {
				result = 0;
				start_x = cur.x;
				start_y = cur.y;
				visited = new boolean[N][N];
				dessert = new boolean[101];
				visited[start_x][start_y] = true;
				dessert[arr[start_x][start_y]] = true;
				dfs(start_x, start_y, 1, 0);

				
			}

			if (max_result == Integer.MIN_VALUE) {
				sb.append(-1 + "\n");
			} else {

				sb.append(max_result + "\n");
			}

		}
		System.out.println(sb);
	}

	static void dfs(int x, int y, int cnt, int dist) {

		for (int i = dist; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (ax == start_x && ay == start_y && cnt > 2) {
				max_result = Math.max(cnt, max_result);
				return;
			}

			if (check(ax, ay) && !dessert[arr[ax][ay]]) {
				visited[ax][ay] = true;
				dessert[arr[ax][ay]] = true;
				dfs(ax, ay, cnt + 1, i);
				visited[ax][ay] = false;
				dessert[arr[ax][ay]] = false;
			}
		}

	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < N && !visited[ax][ay];
	}

}