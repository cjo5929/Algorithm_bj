import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int vertex;
	int value;
	
	public Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	

	@Override
	public int compareTo(Edge o) {
		if(this.value > o.value) return 1;
		else return -1;
	}
	
}

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int V, E, K, u, v, w;
	static PriorityQueue<Edge> q = new PriorityQueue<>(); // 가중치 오름차순 큐
	static ArrayList<Edge>[] list;	
	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		dist = new int[V+1];
		
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Edge(v, w));
			
		}
		
		for(int i = 0; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		q.add(new Edge(K, 0));
		dist[K] = 0;
		
		while(!q.isEmpty()) {
			Edge current = q.poll();
			int vertrix = current.vertex;
			
			if(visited[vertrix]) continue;
			visited[vertrix] = true;
			
			for(int i = 0; i < list[vertrix].size(); i++) {
				
				Edge temp = list[vertrix].get(i);
				
				int next = temp.vertex;
				int value = temp.value;
				
				if(dist[next] > value + dist[vertrix]) {
					dist[next] = value + dist[vertrix];
					q.add(new Edge(next, dist[next]));
				}
			}
			
			
		}
		
		for(int i = 1; i < dist.length; i++) {
			if(visited[i]) {
				sb.append(dist[i] + "\n");
			}else {
				sb.append("INF" + "\n");
			}
		}
	

		System.out.println(sb);
		
		

	}

}