import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author 
 * @date 
 * @link
 * @keyword_solution  
 * @input 
 * @output   
 * @time_complex  
 * @perf 
 */

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Node> q;
	
	static int [] dx = {1, -1, 0, 0};
	static int [] dy = {0, 0, 1, -1};
	static int n;
	static int[][] arr, dist;
	static boolean[][] visited;
	
	static class Node implements Comparable<Node>{
		int x, y, v;

		public Node(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return this.v - o.v;
		}

		
	}
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		int idx = 1;
		while(n != 0) {
			sb.append("Problem " + idx++ + ": ");
			arr = new int[n][n];
			dist = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			q = new PriorityQueue<>();
			q.offer(new Node(0, 0, arr[0][0]));
			dist[0][0] = arr[0][0];
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				
				if(visited[cur.x][cur.y]) continue;
				visited[cur.x][cur.y] = true;
				
				
				for(int i = 0; i < 4; i++) {
					int ax = cur.x + dx[i];
					int ay = cur.y + dy[i];
					
					if(check(ax, ay)) {
						
						if(dist[ax][ay] > dist[cur.x][cur.y] + arr[ax][ay]) {
							dist[ax][ay] = cur.v + arr[ax][ay];
							q.offer(new Node(ax, ay, dist[ax][ay]));
						}
					}
				}
				
			}
			
			sb.append(dist[n-1][n-1] + "\n");
			
			n = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb.toString().trim());
		
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < n && ay >=0 && ay < n;
	}
}