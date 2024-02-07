/**
 * @author 강민서
 * @date 2024.02.07
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV5LtJYKDzsDFAXc&probBoxId=AY13IwlKMEcDFAWX&type=PROBLEM&problemBoxTitle=0205%EC%A3%BC&problemBoxCnt=4
 * @keyword_solution 상하좌우에 있는 다른 방으로 이동
 * 조건1. 이동하는 방이 존재 => 벽을 만나면 안 됨
 * 조건 2. 이동하려면 현재 방 + 1 == 다음 방
 * =>어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램
 * => 각자 숫자에서 시작해서 완전탐색으로 최대인 방을 구해보자
 * @input  (1 ≤ N ≤ 10^3) 배열의 크기가 최대 1000 x 1000 => 완전탐색 가능
 * @output 출발 번호, 최대 방 , 주의 ! 이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력
 * @time_complex O(N^2) 
 * @perf 29,664 321 

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, result, room, cnt;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			result = 0;
			room = N * N + 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					dfs(i, j, 1); // 완전탐색

				}

			}

			sb.append(room + " " + result + "\n");

		}
		System.out.println(sb);

	}

//	dfs 
	static int dfs(int x, int y, int cnt) {

		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (ax >= 0 && ax < N && ay >= 0 && ay < N) {  
				if (arr[ax][ay] == arr[x][y] + 1) {  // 넘어 갈 수 있는 방이면 cnt + 1 해서 넘겨주기

					cnt = dfs(ax, ay, cnt + 1);
				}

			}

		}

//		최대인 방, 시작방 갱신
		if (result < cnt) {
			result = cnt;
			room = arr[x][y];
		} else if (result == cnt && room > arr[x][y]) {
			room = arr[x][y];
		}

		return cnt;
	}
}