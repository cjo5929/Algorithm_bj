import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, K, home_cnt, result, cost;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = N + 1;
			arr = new int[N + 1][N + 1];
			result = Integer.MIN_VALUE;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			0,0 부터 시작해서 최대 k가 n+1 부터 1까지 돌기 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= K; k++) {
						cost = k * k + (k - 1) * (k - 1);
						home_cnt = area_check(i, j, k);
						if ((home_cnt * M) - cost >= 0) {  // 손해가 없다면 통과
							result = Math.max(home_cnt, result);

						}
					}

				}
			}
			sb.append(result + "\n");

		}
		System.out.println(sb);
	}

//	서비스 영역 안에 있는 집의 수 리턴
	static int area_check(int ax, int ay, int k) {

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist_calc(i, j, ax, ay) <= (k - 1)) {
					if (arr[i][j] == 1) {
						cnt++;
					}
				}

			}
		}

		return cnt;
	}

//	서비스 영역 계산
	static int dist_calc(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}

}