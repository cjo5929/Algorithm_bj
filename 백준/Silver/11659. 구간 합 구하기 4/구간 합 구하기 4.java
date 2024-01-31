import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/11659
 * @keyword_solution  i번째 수부터 j번째 수까지 합 => 단순한 구간 합
 * @input 1 ≤ N ≤ 100,000 1 ≤ M ≤ 100,000 => 최악의 경우 O(NM)으로 시간 초과가 날 수 있다. 
 * => 수를 입력 받을 때 각 위치 까지의 합도 함께 구하자
 * @output  입력 별 합을 출력
 * @time_complex  O(N)
 * @perf 54900	656
 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, result;
	static int[] arr, sum;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		sum = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
//			입력 값 받을 때 SUM배열에 지금까지 합 저장
			if(i - 1 >= 0) {
				sum[i] = arr[i] + sum[i-1];
			}else {
				sum[i] = arr[i];
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1; //인덱스 조정
			int end = Integer.parseInt(st.nextToken()) - 1; // 인덱스 조정
			
//			start ~ end 사이에 합을 구하려면 sum[end]에 있는 값이 (start - 1) ~ end 까지의 합이니
//			sum[end] - sum[start - 1]을 해주면 구해짐
			if(start - 1 >= 0) {
				result = sum[end] - sum[start - 1];
			}else {
				result = sum[end];
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
//		5 9 12 14 15
		

	}

}