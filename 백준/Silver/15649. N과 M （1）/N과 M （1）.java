/**
 * @author 강민서
 * @date 0130
 * @link https://www.acmicpc.net/status?user_id=rkdalstj4505&problem_id=15649&from_mine=1
 * @keyword_solution  1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 => 이 문구를 통해 중복 없는 순열을 구하는 것임을 알았음
 * @input (1 ≤ M ≤ N ≤ 8) => 입력 값에 대한 시간은 생각 안 해도됨
 * @output => 사전 순을 증가하는 순서로 int 값 출력, 각 수열은 공백 구분
 * @time_complex  O(n!)
 * @perf 38340kb 528ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		arr = new int[m];
		
		permutation(0);
		
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == m) {
			for(int result : arr) {
				sb.append(result + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i + 1;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}

}