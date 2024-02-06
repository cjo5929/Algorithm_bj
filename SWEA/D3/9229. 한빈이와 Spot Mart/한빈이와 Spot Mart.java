/**
 * @author 강민서
 * @date 2024.02.06
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AW8Wj7cqbY0DFAXN&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0205%EC%A3%BC&problemBoxCnt=2&probBoxId=AY13IwlKMEcDFAWX
 * @keyword_solution  정확히” 두 봉지 사야 함 => 두 개의 숫자를 합해서 최댓값을 찾는다.
 * @input 2 ≤ N ≤ 1000 => O(n^2) 완탐 가능
 * @output 간단하게 최대합 출력  => int로 가능 
 * @time_complex O(n^2)
 * @perf (for문 2개)  32,432kb 206ms, (투포인터)25,868 kb 133 ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, M, max;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int start = 0;
			int end = N - 1;
			max = -1;

//			for문 2개로 완탐 코드
//			for (int i = 0; i < N; i++) {
//				for (int j = i + 1; j < N; j++) {
//					int sum = arr[i] + arr[j];
//					if (sum <= M) {
//						max = Math.max(max, sum);
//					}
//
//				}
//}
			
			
			
	
			// 투포인터로 풀이
			while(start < end) {

				if(arr[start] + arr[end] <= M) {
					max = Math.max(max, arr[start] + arr[end]);
					start++;
				}else end--;
				
				
			}
			
			
		sb.append(max + "\n");	

//			
//
//			
//		}
		

	}
		System.out.println(sb);

}
}