import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, a, b, command;
	static int[] graph;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case 1:
				sb.append((check(a, b) ? "YES" : "NO") + "\n");
				break;
				
			case 0:
				union(a, b);
				break;
			}
		}
		
		System.out.println(sb);
	}
	
//	find 연산
	static int find(int x) {
		if(x == graph[x]) return x; // 루트노드 찾기 (index값과 value가 같은 경우)
		
		return graph[x] = find(graph[x]);
		
	}
	
//  union연산
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) { // 루트노드로 값 변경 
			if(x < y) {
				graph[y] = x;
			}else {
				graph[x] = y;
			}
		}
	}
	
	static boolean check(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return true;
		
		return false;
	}

}