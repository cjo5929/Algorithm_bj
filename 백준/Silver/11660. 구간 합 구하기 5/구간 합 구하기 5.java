import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/11660
 * @keyword_solution (x1, y1)부터 (x2, y2)까지 합=> 2차원 배열에서 구간 합
 * @input . (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) => 최악의 경우 O(N^2M)으로 시간 초과가 날 수 있다.
 *        => 수를 입력 받을 때 각 위치 까지의 합도 함께 구하자
 * @output 입력 별 합을 출력
 * @time_complex O(N^2)
 * @perf 54900 656
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, result;
	static int[][] arr, sum;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		sum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] =   arr[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];

//				입력 값 받을 때 SUM배열에 지금까지 합 저장
//				if (j - 1 >= 0) {
//					
//					
//				}else {
//					if(i == 0) {
//						sum[i][j] = arr[i][j];
//					}else {
//						sum[i][j] = arr[i][j] + sum[i - 1][n - 1];
//					}
//				}
				
			}

		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x_1 = Integer.parseInt(st.nextToken());
			int y_1 = Integer.parseInt(st.nextToken());
			int x_2 = Integer.parseInt(st.nextToken());
			int y_2 = Integer.parseInt(st.nextToken());
			
			sb.append(sum[x_2][y_2] - sum[x_1 - 1][y_2] - sum[x_2][y_1 - 1] + sum[x_1 - 1][y_1 - 1]).append("\n");
		}
		
		System.out.println(sb);



	}

}