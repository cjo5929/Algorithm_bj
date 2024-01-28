import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, r, t;
	static int[][] arr;
	
//	반시계 방향 설정
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		t = 회전하는 그룹 수
		t = Math.min(n, m) / 2;
		for(int i = 0; i < r; i++) {
			rotate();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void rotate() {
		for(int i = 0; i < t; i++) {
			int x = i;
			int y = i;
			
//			첫 번째 값은 회전하면 사라지므로 미리 저장하고 맨 나중에 갱신
			int temp = arr[x][y];
			
			int idx = 0;
//			4방향 돌기
			while(idx < 4) {
				int ax = x + dx[idx];
				int ay = y + dy[idx];
				
				if(ax < n - i && ay < m - i && ax >= i && ay >= i) {
					arr[x][y] = arr[ax][ay];
					x = ax;
					y = ay;
				}
				else {
					idx++;
				}
			}
			
			arr[i+1][i] = temp;
		}

	}
}