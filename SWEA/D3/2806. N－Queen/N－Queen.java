/**
 * @author 강민서
 * @date 2024.02.14
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV7GKs06AU0DFAXB&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0212%EC%A3%BC&problemBoxCnt=2&probBoxId=AY2gBgM6OSIDFAXh
 * @keyword_solution  N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수 => 퀸은 상하좌우 대각선 까지 8방으로 공격가능 
 * @input N(1 ≤ N ≤ 10) => 완탐으로 풀시 10! => 4초 실행시간이면 완탐으로도 충분하지만 N이 커질수록 연산이 매우 많아짐 백트래킹 활용
 * @output 경우의 수 
 * @time_complex  O(N!)
 * @perf 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int T, n, cnt, x, y;
	static boolean check;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			int[][] arr = new int[n][n];
			check = true;

			cntQueen(0, arr);
			sb.append(cnt + "\n");

			
			
		}
		System.out.println(sb);

	}

// 재귀
	static void cntQueen(int depth, int[][] arr) { // depth가 n과 같으면 끝
		// base
		if (depth == n) {
			cnt++;
			return;
		}

		
        for (int i = 0; i < n; i++) {
            if (check(arr, depth, i)) { // 유효성 검사 통과하면 퀸 놓기
                arr[depth][i] = 1;
                cntQueen(depth + 1, arr);
                arr[depth][i] = 0; // 모든 경우의 수 탐색
            }
        }
	}
	
  // 백트래킹
	// 퀸 조건 검사 => 퀸을 놓을 수 있다면 depth를 높이기 depth 아래 놓는 퀸 조건은 제외
	static boolean check(int[][] arr, int depth, int col) {
		
		// 열 검사
		for (int i = 0; i < depth; i++) {
			if(arr[i][col] == 1) return false;
			
		}
		
		// 왼쪽 위 대각선 검사
		x = depth - 1;
		y = col - 1;
		while(x >= 0 && y >= 0) {
			if(arr[x][y] == 1) return false;
			x--;
			y--;
		}
		
		// 오른쪽 위 대각선 검사
		x = depth - 1;
		y = col + 1;
		while(x >= 0 && y < n) {
			if(arr[x][y] == 1) return false;
			x--;
			y++;
		}
		

		return true;
	}

}