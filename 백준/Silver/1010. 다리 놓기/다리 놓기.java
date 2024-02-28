import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, a, b;
	static int[][] dp;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			dp = new int[b + 1][a + 1];
			
			for(int i = 0; i <= b; i++) {
				for(int j = 0, end = Math.min(i, a); j <= end; ++j) {
					if(j == 0 || i == j) dp[i][j] = 1;
					else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}
			}
			
			sb.append(dp[b][a] + "\n");
			
		}
		System.out.println(sb);
		
	}

}