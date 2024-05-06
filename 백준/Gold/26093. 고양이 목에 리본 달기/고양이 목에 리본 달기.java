import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp, arr;
	static int[] before;
	static int n, k;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][k];
		dp = new int[n][k];
		before = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < k; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		for (int i = 0; i < k; i++) {
			dp[0][i] = arr[0][i];
		}
		before = Arrays.copyOf(dp[0], k);

		Arrays.sort(before);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {

				if (dp[i - 1][j] == before[k - 1]) {
					dp[i][j] = arr[i][j] + before[k - 2];
				} else {
					dp[i][j] = arr[i][j] + before[k - 1];
				}
			}
			
			before = Arrays.copyOf(dp[i], k);
			Arrays.sort(before);

		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < k; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		

		System.out.println(before[k - 1]);
	}

}