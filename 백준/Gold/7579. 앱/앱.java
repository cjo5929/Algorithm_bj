import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, result;
	static int[] memory;
	static int[] cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		memory = new int[n + 1];
		cost = new int[n];
		dp = new int[n + 1][100001];
		result = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < 100001; j++) {
				int point = cost[i - 1];
				int memo = memory[i];
				
				if(j < point) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Integer.max(dp[i-1][j], dp[i-1][j-point] + memo);
				}
				
				if(dp[i][j] >= m) {
					result = Integer.min(j, result);
				}
			}
			

		}
		
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j < 8; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		System.out.println(result);
		
	}

}