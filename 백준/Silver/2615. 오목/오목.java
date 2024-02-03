import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author
 * @date
 * @link
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
	static int[] dx = { 1, 1, 1, 0 };
	static int[] dy = { 1, 0, -1, 1 };
	static int[][] maps;

	public static void main(String[] args) throws IOException {

		maps = new int[19][19];

		// board 입력받기
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {

				if (maps[i][j] != 0) {

					for (int k = 0; k < 4; k++) {
						int ax = i;
						int ay = j;
						int cnt = 1;

						while (true) {
							ax += dx[k];
							ay += dy[k];

							if (!check(ax, ay))
								break;

							if (maps[ax][ay] == maps[i][j]) {
								cnt++;
							} else {
								break;
							}

						}

						ax = i;
						ay = j;

						while (true) {
							ax -= dx[k];
							ay -= dy[k];

							if (!check(ax, ay))
								break;

							if (maps[ax][ay] == maps[i][j]) {
								cnt++;
							} else {
								break;
							}
						}

						if (cnt == 5) {
							sb.append(maps[i][j]).append("\n").append((i + 1) + " " + (j + 1));
							System.out.println(sb);
							return;
						}
					}
				}
			}
		}
		
		sb.append(0);
		System.out.println(sb);
	}

	static boolean check(int ax, int ay) {
		if (ax < 0 || ax >= 19 || ay < 0 || ay >= 19 || maps[ax][ay] == 0)
			return false;
		else
			return true;
	}

}