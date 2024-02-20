import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] degree;
	static Queue<Integer> q = new ArrayDeque<>();
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		degree = new int[N + 1];
		graph = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			degree[b]++;
		}
		bfs();
		System.out.println(sb);
		
		
	}
	
	static void bfs() {
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			sb.append(current + " ");
			
			for(int i = 0; i < graph[current].size(); i++) {
				int next = graph[current].get(i);
				if(--degree[next] == 0) {
					q.add(next);
				}
			}
		}
	}

}