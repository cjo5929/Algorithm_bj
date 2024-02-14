/**
 * @author 강민서
 * @date 2024.02.14
 * @link https://www.acmicpc.net/problem/1074
 * @keyword_solution   2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문 => 재귀사용
 * N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성 => 시작은 0번부터 
 * @input 1 ≤ N ≤ 15, 0 ≤ r, c < 2N => 최악의 경우 O(2^15 * 2^15) 
 * @output 방문 cnt 출력 
 * @time_complex 
 * @perf 14280	128
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, r, c, cnt;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, N);
		
		dfs(size, r, c);

		System.out.println(cnt);
	}
	
	static void dfs(int size, int i, int j) {
		if(size == 1) return;
		
		if(i < size / 2 && j < size / 2) {
			dfs(size / 2, i, j);
			
		}else if(i < size / 2 && j >= size / 2) {
			cnt += (size * size) / 4;
			dfs(size / 2, i, j - (size / 2));
			
		}else if(i >= size / 2 && j < size / 2) {
			cnt += (size * size / 4) * 2;
			dfs(size / 2, i - (size / 2) , j);
			
		}else if(i >= size / 2 && j >= size / 2) {
			cnt += (size * size / 4) * 3;
			dfs(size / 2, i - (size / 2) , j - (size / 2));
			
		}
		
	}

}