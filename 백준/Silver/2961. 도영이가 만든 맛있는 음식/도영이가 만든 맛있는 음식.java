import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.01
 * @link https://www.acmicpc.net/problem/2961
 * @keyword_solution 신맛 S는 곱, 쓴맛 B 합 => 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 
 * => 신맛과 쓴맛 부분집합을 구한 뒤 최솟값 계속 리턴
 * @input N(1 ≤ N ≤ 10) 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수
 * @output 요리의 차이로 int형으로 가능
 * @time_complex O(2^n)
 * @perf 14120	120
 */


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, min;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
//			2차원 배열을 만든 뒤 첫 번째 열에 신맛 저장, 두 번째 열에 쓴맛 저장 
			arr[i][0] = Integer.parseInt(st.nextToken()); 
			arr[i][1] = Integer.parseInt(st.nextToken());
		
			
		}
		
		min = Integer.MAX_VALUE;
		PowerSet(0, 1, 0);
		sb.append(min);
		System.out.println(sb);
		

	}
	
	static void PowerSet(int toCheck, int sour, int bitter) { // toCheck : 집합 체크 sour : 신맛 , bitter : 쓴맛
		if(toCheck == N) {
			int falseCnt = 0; // 빈 집합은 안 되기 때문에 체크
			for(int i=0;i<N;i++) {
				if(visited[i]) continue;
				falseCnt++;
			}
			if(falseCnt == N) return; // 빈 집합이면 리턴
			min = Math.min(min, Math.abs(sour - bitter)); //최솟값 갱신
			return;
		}
		
		visited[toCheck] = true;
		PowerSet(toCheck + 1, sour * arr[toCheck][0], bitter + arr[toCheck][1]);
		visited[toCheck] = false;
		PowerSet(toCheck + 1, sour, bitter);

	}
	



}