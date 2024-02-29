/**
 * @author 강민서
 * @date 2024.02.28
 * @link https://www.acmicpc.net/problem/17070
 * @keyword_solution  
 * 가로 = 가로 , 대각선
 * 세로 = 세로 , 대각선
 * 대각선 = 가로 , 세로 , 대각선
 * => dp배열에 가능한 경우의 수를 포함하면서 계산 
 * @input N(3 ≤ N ≤ 16) => N이 최대 16으로 dfs로도 풀이 가능 
 * @output  개수출력
 * @time_complex O(N^2)
 * @perf 11640	80
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, cnt, index, ax, ay;
	static long[][] arr;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		arr = new long[N][N];
		dp = new long[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
//		0  가로 1 세로 2 대각선
		dp[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
//				가로
				if (j - 1 >= 0 && arr[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				}

//				세로
				if (i - 1 >= 0 && arr[i][j] == 0) {
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				}

//				대각
				if (j - 1 >= 0 && i - 1 >= 0 && arr[i][j] == 0 && arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
					dp[i][j][2] = dp[i - 1][j - 1][1] + dp[i - 1][j - 1][0] + dp[i - 1][j - 1][2];
				}
			}
		}
	
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);

	}

}