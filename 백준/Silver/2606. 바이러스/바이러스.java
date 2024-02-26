import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;




public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int N, M, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				
				if(!visited[next]) {
					cnt++;
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		System.out.println(cnt);
	}

}