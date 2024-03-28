import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
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
	static int R, C, result;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> wa_q = new ArrayDeque<>();
	static Queue<Point> go_q = new ArrayDeque<>();
	static boolean possible;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
			
			for(int j = 0; j < C; j++) {
				
				if(arr[i][j] == '*') {
					wa_q.offer(new Point(i, j));
				}else if(arr[i][j] == 'S') {
					go_q.offer(new Point(i, j));
				}
					
			}
		}
		
		bfs();
		
		if(possible) {
			System.out.println(sb);
		}else {
			System.out.println("KAKTUS");
		}
		
		
	}
	
	
	static void bfs() {
		
		while(true) {
			
//			물 움직임
			int wa_q_size = wa_q.size();
			int go_q_size = go_q.size();
			
			if(wa_q_size == 0 && go_q_size == 0) {
				possible = false;
				return;
			}
			
			while(wa_q_size-- > 0) {
				
				Point cur = wa_q.poll();
				
				for(int i = 0; i < 4; i++) {
					int ax = cur.x + dx[i];
					int ay = cur.y + dy[i];
					
					if(check(ax, ay)) {
						if(arr[ax][ay] == '.') {
							arr[ax][ay] = '*';
							wa_q.offer(new Point(ax, ay));
						}
					}
				}
				
				
			}
					
//			고슴도치 움직임 
			
			result++; //이동 시간++
			
			while(go_q_size-- > 0) {
				
				Point cur = go_q.poll();
				
				for(int i = 0; i < 4; i++) {
					int ax = cur.x + dx[i];
					int ay = cur.y + dy[i];
					
					if(check(ax, ay)) {
						if(arr[ax][ay] == '.' && !visited[ax][ay]) {
							visited[ax][ay] = true;
							go_q.offer(new Point(ax, ay));
						}
						
						if(arr[ax][ay] == 'D') {
							sb.append(result);
							possible = true;
							return;
						}
					}
				}
				
				
			}
			
			
		}
		
	}
	
	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < R && ay >= 0 && ay < C;
	}
		

}