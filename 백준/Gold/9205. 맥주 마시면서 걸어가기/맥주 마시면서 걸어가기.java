import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	 
	static int n;
	static ArrayList<ArrayList<Integer>> maps;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			n = Integer.parseInt(br.readLine());
			Point [] nodes = new Point[n+2];
			
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				nodes[i] = new Point(x, y);
	
			}
			
			maps = new ArrayList<>();
			for(int i = 0; i < n+2; i++) maps.add(new ArrayList());
			
			for(int i = 0; i < n + 1; i++) {
				for(int j = i + 1; j < n + 2; j++){
					int dist = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
					
					if(dist <= 1000) {
						maps.get(i).add(j);
						maps.get(j).add(i);
					}
				}
			}
			
			System.out.println(bfs());
			
		}

	}
	static String bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		boolean [] visited = new boolean[n+2];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == n+1) return "happy";
			for(int next : maps.get(cur)){
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
				
		}
		return "sad";
		
		
		
	}

}