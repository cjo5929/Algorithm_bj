/**
 * @author 강민서
 * @date 2024.02.20
 * @link https://www.acmicpc.net/problem/10026
 * @keyword_solution 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
 * => 색 배열에서 적록색약과 아닌 사람으로 구분하여 그림의 구역의 수를 출력하는 문제
 * => dfs탐색으로 배열 전체를 돌면서 같은 색인 부분을 체크하고 구역이 끝나면 cnt를 증감하는 방식
 * => 적록색약은 단순하게 G를 R로 바꿔주면서 다시 DFS 돌림
 * @input  (1 ≤ N ≤ 100) => N이 최대 100으로 입력 값이 크지 않아서 시간은 고려 안 해도됨
 * @output 구역의 수를 공백으로 나눠서 출력
 * @time_complex  o(n^2)
 * @perf  17056	156
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, cnt;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}

//		정상
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}

			}
		}
		sb.append(cnt + " ");

		cnt = 0;
		visited = new boolean[N][N];

//		적록색약 초록을 빨강으로 교체
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}

//		적록색약 구역 탐색 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}

			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}

//	dfs 탐색
	static void dfs(int x, int y) {

		visited[x][y] = true;

		char save = arr[x][y];   // 주변 색이 같은 색인지 구별을 위해 저장
		
//		사방탐색
		for (int i = 0; i < 4; i++) {

			int ax = x + dx[i];
			int ay = y + dy[i];

			if (check(ax, ay) && arr[ax][ay] == save) {
				dfs(ax, ay);
			}

		}
		
		return;
	}

	static boolean check(int ax, int ay) {
		return (ax >= 0 && ax < N && ay >= 0 && ay < N && !visited[ax][ay]);
	}

}