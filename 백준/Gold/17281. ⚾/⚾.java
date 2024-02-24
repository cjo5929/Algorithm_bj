/**
 * @author 강민서
 * @date 2024.02.23
 * @link https://www.acmicpc.net/problem/17281
 * @keyword_solution  야구 규칙 시뮬레이션
 * @input N(2 ≤ N ≤ 50) => 최악의 경우 8! * 50 => 1초 내에 연산 가능 
 * @output 최대 점수를 출력
 * @time_complex O(8! * N)
 * @perf 63996 588
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, d, out, score;
	static int[] lineUP;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		lineUP = new int[9];
		visited = new boolean[9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		// 4번타자는 고정
		lineUP[3] = 0; // 4번 타자는 1번 선수
		visited[3] = true;

		permu(1);
		System.out.println(score);

	}

//	순열
	static void permu(int depth) {
		if (depth == 9) {

			score = Math.max(score, gameStart());
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lineUP[i] = depth;
				permu(depth + 1);
				visited[i] = false;
			}

		}

	}

	static int gameStart() {
		int sum = 0; // 점수 합산
		int current = 0; // 시작 선수

		for (int r = 0; r < N; r++) {
			int score = 0; // 이닝 점수
			out = 0; // 이닝마다 아웃 초기화
			boolean[] base = new boolean[4]; // 이닝마다 base초기화

//			3아웃 이닝 교체
			while (out < 3) {

				switch (arr[r][lineUP[current]]) {

//				아웃
				case 0:
					out++;
					break;

//				1루타
				case 1:
					if (base[3]) {
						score++;
						base[3] = false;
					}
					if (base[2]) {
						base[3] = true;
						base[2] = false;
					}
					if (base[1]) {
						base[2] = true;
					}
					base[1] = true;
					break;

				// 2루타
				case 2:
					if (base[3]) {
						score++;
						base[3] = false;
					}
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;
					break;

				// 3루타
				case 3:
					if (base[3]) {
						score++;
					}
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						score++;
						base[1] = false;
					}
					base[3] = true;
					break;

				// 홈런
				case 4:
					if (base[3]) {
						score++;
						base[3] = false;
					}
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						score++;
						base[1] = false;
					}
					score++;
					break;
				}

				current++; // 다음 타자

//				타자 순번 다 돌면 0으로 초기화
				if (current >= 9) {
					current = 0;
				}
			}

			sum += score; // 이닝 점수 합신

		}

		return sum;
	}

}