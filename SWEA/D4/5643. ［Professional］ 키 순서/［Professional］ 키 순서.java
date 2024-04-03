import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, result;
	static int[][] arr;
	static boolean[] visited;


	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];
			result = 0;
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					arr[i][j] = 100000;
				}
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
			}
			

			
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}

			
			for(int i = 1; i <= N; i++) {
				int cnt = 0;
				
				for(int j = 1; j <= N; j++) {
					if(arr[i][j] != 100000 || arr[j][i] != 100000) {
						cnt += 1;
					}
				}
				
				if(cnt == N - 1) {
					result++;
				}
				
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);

	}
	

}