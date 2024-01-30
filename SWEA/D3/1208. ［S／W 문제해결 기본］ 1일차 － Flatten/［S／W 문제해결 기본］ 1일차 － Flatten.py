import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.01.30
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV139KOaABgCFAYh&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=4
 * @keyword_solution 
 * 조건 1. 평탄화 작업 - > 최고점에 있는 블럭을 최저점으로  -> 덤프 1회
 * 조건 2. 덤프 횟수 만큼 반복한 뒤 최고점과 최저점 높이의 차이 => 정렬을 덤프만큼 반복해서 맨 앞과 맨 뒤를 뺀다
 * 조건 3. 같은 높이의 최고점, 최저점이 있을 때 어디에 놓는지는 생각 안 해도 됨
 * 
 * @input 100크기의 배열, 덤프 횟수는 1000이하 => N^2가능
 * @output 단순한 int 출력
 * @time_complex O(n^2) - >Arrays.sort 최악의 경우 
 * @perf 21,460 kb 124 ms
 */

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, max, min, max_temp, min_temp;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case + " ");
			int dump_cnt = Integer.parseInt(br.readLine());
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			arr = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
	
			for(int i = 0; i < dump_cnt; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
				
			}
			Arrays.sort(arr);

		sb.append(arr[99] - arr[0] + " ");
		sb.append("\n");

	}
		System.out.println(sb);
	}
	
}