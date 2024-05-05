import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, c_x, c_y, e_x, e_y;
	static char[][] arr;
	static int[][] dist;
	static PriorityQueue<Node> pq;
	static int[] dx = { 1, 0, 0 };
	static int[] dy = { 0, 1, -1 };
	static int[] move = { 5, 1, 1 };

	static class Node implements Comparable<Node> {
		int x, y, dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);

				if (arr[i][j] == 'C') {
					c_x = i;
					c_y = j;
				} else if (arr[i][j] == 'E') {
					e_x = i;
					e_y = j;
				}

			}

		}

		dijk();
		
		if(dist[e_x][e_y] == Integer.MAX_VALUE) {
			System.out.println("dodo sad");
		}else {
			System.out.println(dist[e_x][e_y]);
		}
	}

	static void dijk() {
		pq = new PriorityQueue<Node>();
		pq.offer(new Node(c_x, c_y, 0));
		dist[c_x][c_y] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.x][cur.y] < cur.dist)
				continue;
			if (cur.x == e_x && cur.y == e_y)
				return;

//			사다리에 위치했을 때 위로 이동
			if (arr[cur.x][cur.y] == 'L') {
				int ax = cur.x - 1;

				if (check(ax, cur.y) && dist[ax][cur.y] > dist[cur.x][cur.y] + 5) {
					dist[ax][cur.y] = dist[cur.x][cur.y] + 5;
					pq.offer(new Node(ax, cur.y, dist[ax][cur.y]));
				}

			}

//	   		이동이 가능하다면(좌우 아래)
			if (arr[cur.x][cur.y] != 'X') {

				for (int i = 0; i < 3; i++) {
					int ax = cur.x + dx[i];
					int ay = cur.y + dy[i];

					if (check(ax, ay)) {

//						아래로 이동할 때 사다리가 없다면 패스
						if (i == 0 && arr[ax][ay] != 'L')
							continue;

						if (dist[ax][ay] > dist[cur.x][cur.y] + move[i]) {
							dist[ax][ay] = dist[cur.x][cur.y] + move[i];
							pq.offer(new Node(ax, ay, dist[ax][ay]));

						}
					}
				}
			}

//			허공 추락
			if (arr[cur.x][cur.y] == 'X') {
				int ax = cur.x + 1;

				while (check(ax, cur.y) && arr[ax][cur.y] == 'X')
					ax++;

				if (check(ax, cur.y)) {
					if (dist[ax][cur.y] > dist[cur.x][cur.y] + 10) {
						dist[ax][cur.y] = dist[cur.x][cur.y] + 10;
						pq.offer(new Node(ax, cur.y, dist[ax][cur.y]));
					}
				}
			}

		}

	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < n && ay >= 0 && ay < m && arr[ax][ay] != 'D';
	}

}