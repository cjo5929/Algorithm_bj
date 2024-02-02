/**
 * @author 강민서		
 * @date 2024.02.02
 * @link https://www.acmicpc.net/problem/2164
 * @keyword_solution   우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 *  => 지문에서 봤을 때 카드 움직임이 큐와 같은 구조로 되어 있음을 확인 
 * @input  N(1 ≤ N ≤ 500,000) -> O(N)
 * @output int형으로 카드의 번호 출력 
 * @time_complex  
 * @perf 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		
		while(q.size() > 1) {
			q.poll();
			int down = q.poll();;
			q.add(down);
			
			
		}

		System.out.println(q.peek());
	}

}