import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, cnt, index, ax, ay;
	static int[][] arr;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N][3];

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