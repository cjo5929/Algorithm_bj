/**
 * @author 강민서
 * @date 2024.02.01
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV5PzOCKAigDFAUq&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=6
 * @keyword_solution  M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다. => N X N 배열에서 M X M 배열의 합을 모든 경우의 수를 구하고 비교
 * @input  N 은 5 이상 15 이하, M은 2 이상 N 이하 => 완탐을 해도 O(N^2) 
 * @output (#1 49) 형식으로 최댓 값 출력
 * @time_complex  O(N^2)
 * @perf 18,772 kb 137 ms
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, sum, result;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = Integer.MIN_VALUE;
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		완전탐색
		for(int i = 0; i < N - (M - 1); i++) {
			for(int j = 0; j < N  - (M - 1); j++) {
				result = 0;
				for(int x = 0; x < M; x++) {
					for(int y = 0; y < M; y++) {
						result += arr[i + x][j + y];
						
					}
				}
				sum = Math.max(sum, result); 

			}
		}
		
		sb.append(sum + "\n");
		
	}
		System.out.println(sb);
	}

}