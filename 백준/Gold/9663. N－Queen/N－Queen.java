import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 강민서
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/9663
 * @keyword_solution N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제 => 퀸은 같은 행, 열, 대각선 공격
 *                   가능
 * @input (1 ≤ N < 15) -> 완탐 가능
 * @output -> 경우의 수 출력
 * @time_complex
 * @perf
 */

public class Main {

	static int n, cnt, x, y;
	static boolean check;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		int[][] arr = new int[n][n];
		check = true;

		cntQueen(0, arr);
		sb.append(cnt);
		System.out.println(sb);

	}

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
	
	// 퀸 조건 검사
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