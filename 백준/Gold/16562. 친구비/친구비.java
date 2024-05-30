import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, k, result;
	static boolean[] visited;
	static int[] arr;
	static ArrayList<Node> list;
	static ArrayList<Node>[] map;
	static ArrayDeque<Integer> q;

	static class Node implements Comparable<Node> {
		int num, point;

		public Node(int num, int point) {
			this.num = num;
			this.point = point;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.point, o.point);
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", point=" + point + "]";
		}

		
	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		list = new ArrayList<>();
		visited = new boolean[n + 1];
		map = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			map[i] = new ArrayList<Node>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(new Node(b, arr[b]));
			map[b].add(new Node(a, arr[a]));
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				list = new ArrayList<>();
				list.add(new Node(i, arr[i]));
				bfs(i);
				
				Collections.sort(list);
				result += list.get(0).point;
				
			}
		}
		
		if(result <= k) {
			System.out.println(result);
		}else {
			System.out.println("Oh no");
		}
		
	}
	
	static void bfs(int start) {
		q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0; i < map[cur].size(); i++) {
				Node next = map[cur].get(i);
				
				if(!visited[next.num]) {
					list.add(new Node(next.num, arr[next.num]));
					q.offer(next.num);
					visited[next.num] = true;
				}
			}
		}
	}

}