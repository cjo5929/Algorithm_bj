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
			arr = new int[N];
			dp = new int[N];
			result = 0;
			 
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < N; i++) {
				
				int idx = binarySearch(arr[i], 0, result, result + 1);
								
				if(idx == -1) {
					dp[result++] = arr[i];
					
				}else {
					dp[idx] = arr[i];
				}
				
			}

			
			sb.append(result + "\n");

			
		}
		System.out.println(sb);
		
	}
	
	static int binarySearch(int num, int start, int end, int size) {
		int search = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(num <= dp[mid]) {
				search = mid;
				end = mid - 1;
			} 
			else {
				start = mid + 1;
			}
		}
		
//		가장 큼
		if(start == size) {
			return -1;
		}else {
			return search;
		}
		
		
	}

}