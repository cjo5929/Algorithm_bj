import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, result, edge;
	static int[] parent;
	static boolean[] visited;
	static Queue<Edge> q = new PriorityQueue<Edge>();

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int value;

		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		public int compareTo(Edge o) {

			return this.value - o.value;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		
		for (int i = 0 ; i < V + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			q.add(new Edge(start, end, value));
		}

		
		while(edge < V - 1) {
			Edge cur = q.poll();
			
			if(find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				result += cur.value;
				edge++;
			}
		}
		
		sb.append(result);
		System.out.println(sb);

	}

//	union 연산 
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

//	find 연산 => 사이클 여부 확인
	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

}