/**
 * @author 강민서
 * @date 2024.02.05
 * @link https://www.acmicpc.net/problem/1158
 * @keyword_solution  
 * @input (1 ≤ K ≤ N ≤ 5,000)
 * @output 순열 출력 <3, 6, 2, 7, 5, 1, 4> => 형식 주의
 * @time_complex  
 * @perf 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K;
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		sb.append("<");
		while(q.size() > 1) {
			
			for(int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll() + ", ");
			
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}

}