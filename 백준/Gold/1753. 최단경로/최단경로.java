import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int vertex;
	int value;

	Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.value > o.value)
			return 1;
		else
			return -1;
	}

}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int V, E, K, u, v, w;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	static ArrayList<Edge>[] list;
	static int[] distance;
	static boolean[] visited;
	static boolean check;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		distance = new int[V + 1];  // 노드 간의 거리 저장을 위한 배열
		visited = new boolean[V + 1]; // 방문체크를 위한 visited
		list = new ArrayList[V + 1]; // 연결리스트
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE; // 노드 간 거리 초기화
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			list[u].add(new Edge(v, w));  // 인접 그래프 연결
		}
		
		q.add(new Edge(K, 0));  // 시작 정점 q에 add
		distance[K] = 0;
		
		while(!q.isEmpty()) {
			Edge current = q.poll();
			int c_v = current.vertex;
			
			if(visited[c_v]) continue; // 방문한 노드는 넘김
			visited[c_v] = true;
			
			for(int i = 0; i < list[c_v].size(); i++) { // 인정한 노드를 다 순회
				Edge temp = list[c_v].get(i);
				int next = temp.vertex;
				int value = temp.value;
				if(distance[c_v] + value < distance[next]) { // 저장되어 있는 거리보다 작은 경우 갱신
					distance[next] = distance[c_v] + value;
					q.add(new Edge(next, distance[next]));
				}
			}
			
		}
		
		for(int i = 1; i <= V; i++) {
			if(visited[i]) {
				System.out.println(distance[i]);
			}else {
				System.out.println("INF");
			}
		}
		

	}



}