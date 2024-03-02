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
	static int T, N, K, max_result;
	static int[][] arr;
	static ArrayList<Point> start_list;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			start_list = new ArrayList<Point>();
			visited = new boolean[N][N];
			max_result = 0;
			int max_height = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					max_height = Math.max(max_height, arr[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max_height == arr[i][j]) {
						start_list.add(new Point(i, j));
					}
				}
			}

			for (Point start : start_list) {

				visited[start.x][start.y] = true;
				dfs(start.x, start.y, 1, true);
				visited[start.x][start.y] = false;

			}
			
			sb.append(max_result + "\n");

		}
		System.out.println(sb);
	}

	static void dfs(int x, int y, int len, boolean flag) {
		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (!check(ax, ay))
				continue;
			if (arr[ax][ay] < arr[x][y]) {
				visited[ax][ay] = true;
				dfs(ax, ay, len + 1, flag);
				visited[ax][ay] = false;

			} else if (flag) {
				for (int k = 1; k <= K; k++) {
					if (arr[ax][ay] - k < arr[x][y]) {
						arr[ax][ay] -= k;
						flag = false;
						visited[ax][ay] = true;
						dfs(ax, ay, len + 1, flag);
						flag = true;
						arr[ax][ay] += k;
						visited[ax][ay] = false;
					}
				}
			}

		}

		max_result = Math.max(max_result, len);
		return;
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < N && !visited[ax][ay];
	}

}