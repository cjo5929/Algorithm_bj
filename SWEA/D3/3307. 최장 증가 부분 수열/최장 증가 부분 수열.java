import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, T, result;
	static int[] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			dp = new int[N + 1];
			result = 0;
			 
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i < N + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i < N + 1; i++) {
				dp[i] = 1;
				
				for(int j = 1; j < i; j++) {
					
					if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
					
					
					
				}
				
				result = Math.max(dp[i], result);
			}
			
						
			
			sb.append(result + "\n");
			
			
		}
		System.out.println(sb);
		
	}

}