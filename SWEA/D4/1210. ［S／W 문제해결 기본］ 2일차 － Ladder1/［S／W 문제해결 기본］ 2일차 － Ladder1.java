import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.01.30
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV14ABYKADACFAYh&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=4
 * @keyword_solution 조건 1. X=0인 출발점에서 => 출발은 항상 x = 0 인곳만 
 * 					 조건 2. 아래 방향으로 진행하면서 좌우방향으로 이동 가능한 => 항상 아래쪽으로 이동하고 좌우만 신경쓰면 됨 -> 3방탐색, 우선순위는 좌우
 *                   조건 3. 0’으로 채워진 평면상에 사다리는 연속된 ‘1’로 표현된다. 도착 지점은 '2'로 표현된다 => 2에서 부터 시작하면 길 하나만 탐색해서 찾을 수 있다!!
 *                   => 탐색 한 곳은 0으로 채우기
 * @input 100 x 100 2차원 배열 -> 완전탐색 문제 없음
 * @output 출발점 x좌표 공백 없이, 단순한 int형
 * @time_complex
 * @perf
 */

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };

	static int ax, ay, result_x, result_y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		arr = new int[100][100];

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case + " ");
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] == 2) {
						result_x = i;
						result_y = j;
					}

				}

			}

			while (true) {
				if (result_x == 0) {
					sb.append(result_y);
					break;
				}
				for (int i = 0; i < 3; i++) {
					int ax = result_x + dx[i];
					int ay = result_y + dy[i];

					if (ax >= 0 && ax < 100 && ay >= 0 && ay < 100 && arr[ax][ay] == 1) {
						arr[result_x][result_y] = 0;
						result_x = ax;
						result_y = ay;
					}
				}
			}

			sb.append("\n");

		}
		System.out.println(sb);

	}

}