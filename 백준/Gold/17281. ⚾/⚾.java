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
import java.util.Arrays;
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

		lineUP[3] = 0;
		visited[3] = true;

		permu(1);
		sb.append(score);
		System.out.println(sb);

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
		int current_player = 0; // 시작 선수

		for (int i = 0; i < N; i++) {
			int cnt = 1; // 타자는 1로 고정 
			out = 0;
			
//			3아웃 이닝 교체
			while(out < 3) {
				int result = arr[i][lineUP[current_player]];
				
				if(result == 0) out++;
				else {
					cnt = cnt << result;  // 1루타 => 1칸 밀기, 2루타 => 2칸 밀기, 3루타 => 3칸 밀기
					cnt = cnt | 1;        // 타자 다시 입력
				}
				
				if(cnt > 15) {
					for(int k = 1 << 4; k < 256; k <<= 1) {
						if((cnt & k) == 0) continue;
						cnt ^= k;
						sum++;
					}
				}
				
				
				
				

//				타자 순번 다 돌면 0으로 초기화
				if (++current_player >= 9) {
					current_player = 0;
				}	
			}
			

	

		}

		return sum;
	}
}