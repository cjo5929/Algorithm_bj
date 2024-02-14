import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int r, c, n;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> q = new ArrayDeque<>();
	

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new char[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}
		
		if(n % 2 == 0) { // 2초 마다 모든 자리에 폭탄을 놓게됨
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			return;
		}
		
		int time = 2; 
		while(time++ <= n) {
			if(time % 2 == 1) { // 홀수 초 마다 폭탄이 터지고 배열이 변경됨
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						if(arr[i][j] == 'O') {  // 터질 포탄을 q에 저장
							q.offer(new Point(i, j));
						}
					}
					
				}
				
				for(int i = 0; i < r; i++) { // 터지기 전에 모든 자리에 폭탄 설치 
					Arrays.fill(arr[i], 'O');
				}
				
//				아까 q에 저장된 폭탄 위치를 빼면서 주변 터트림
				while(!q.isEmpty()) {
					Point p = q.poll();
					arr[p.x][p.y] = '.';
					
					for(int i = 0; i < 4; i++) {
						int ax = p.x + dx[i];
						int ay = p.y + dy[i];
						
						if(check(ax, ay)) {
							arr[ax][ay] = '.';
						}
					}
					
				}
				
			}
			
		}

		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	static boolean check(int ax, int ay) {
		if (ax >= 0 && ax < r && ay >= 0 && ay < c && arr[ax][ay] != '.') {
			return true;
		}

		return false;
	}

}