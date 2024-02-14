import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.14
 * @link https://www.acmicpc.net/problem/3109
 * @keyword_solution
 * @input
 * @output
 * @time_complex
 * @perf
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int r, c, result;
	static char[][] arr;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static boolean complete;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		result = 0;

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			complete = false;
			dfs(i, 0);
		}

		System.out.println(result);

	}

	static void dfs(int x, int y) {
		if (y == c - 1) {
			result++;
			arr[x][y] = '-';
			complete = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (check(ax, ay)) {
				dfs(ax, ay);

				if (complete) {
					arr[ax][ay] = '-';
					return;
				} else {
					arr[ax][ay] = '-';
				}

			}

		}

	}

	static boolean check(int ax, int ay) {
		if (ax >= 0 && ax < r && ay >= 0 && ay < c && arr[ax][ay] == '.')
			return true;

		return false;
	}

}