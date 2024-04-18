import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, t, result, cnt;
	static PriorityQueue<Edge> pq;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int a, b, cost;

		/**
		 * @param a
		 * @param b
		 * @param cost
		 */
		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		parent = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		result = 0;
		cnt = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(find(cur.a) != find(cur.b)) {
				result += (cnt * t + cur.cost);
				union(cur.a, cur.b);
				cnt++;
			}
		}
		
		System.out.println(result);

	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}