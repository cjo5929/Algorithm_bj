/**
 * @author 강민서
 * @date 2024.02.27
 * @link https://www.acmicpc.net/problem/1149
 * @keyword_solution  규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값 => 1번 집부터 색을 칠하면서 모든 경우의 수를 탐색을 했고 그 과정에서 dp배열에 최솟값 저장 
 * @input N(2 ≤ N ≤ 1,000)
 * @output 최솟값을 출력  
 * @time_complex  O(N * 3)
 * @perf 12160	96
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, result;
	static int[][] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {

				if (dp[i][j] == 0) {
					
					if (j == 0) {
						dp[i][j] = Math.min(dp[i - 1][j + 1] + arr[i][j], dp[i - 1][j + 2] + arr[i][j]);

					}

					if (j == 1) {
						dp[i][j] = Math.min(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j + 1] + arr[i][j]);

					}
					if (j == 2) {
						dp[i][j] = Math.min(dp[i - 1][j - 2] + arr[i][j], dp[i - 1][j - 1] + arr[i][j]);

					}

				}
			}
		}

		for (int j = 0; j < 3; j++) {
			result = Math.min(result, dp[N - 1][j]);
		}
		System.out.println(result);

	}

}