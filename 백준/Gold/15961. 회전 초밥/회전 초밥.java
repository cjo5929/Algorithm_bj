/**
 * @author 강민서
 * @date 2024.02.23
 * @link https://www.acmicpc.net/problem/15961
 * @keyword_solution 
 * 1. k개의 접시를 연속 => k크기의 슬라이딩 윈도우 생성
 * 2.  쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공 => 쿠폰 초밥은 입력 받을 때 카운팅 
 * @input , 2 ≤ N ≤ 3,000,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d
 * => 최악의 경우 (N/2 * 3000 ^ 2)
 * @output  최대 정수 출력
 * @time_complex  O(N)
 * @perf 168660 524
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, d, k, c, result, max_result;
	static int[] arr, cnt_arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[N];
		cnt_arr = new int[d + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}

		for (int i = 0; i < k; i++) {
			cnt_arr[arr[i]]++;
		}
		

		cnt_arr[c]++; // 쿠폰 설정
		
		for(int i = 1; i <= d; i++) {
			if(cnt_arr[i] != 0) result++;
		}


		max_result = 0;
		int start = 1;
		int end = start + (k - 1);
		for (start = 1; start < N; start++) {

			cnt_arr[arr[start - 1]]--;
			
			if(cnt_arr[arr[start - 1]] == 0) {
				result--;
			}
			
			cnt_arr[arr[end]]++;
			
			if(cnt_arr[arr[end]] == 1) {
				result++;
			}

			max_result = Math.max(result, max_result);
			
			end++;
			
			if (end >= N) {
				end = 0;
			}

		}

		System.out.println(max_result);

	}

}