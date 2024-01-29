import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int [] dx = {1, 1, 1, 0}; 
	static int [] dy = {1, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		int [][] maps = new int[19][19];
		
		//		board 입력받기
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		왼쪽 위에서 차례대로 가기 때문에 세로, 가로, 왼쪽 아래 대각, 오른쪽 아래 대각 총 4방 탐색
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				
				if(maps[i][j] != 0) {
					for(int k = 0; k < 4; k++) {
						int ax = i;
						int ay = j;
						int cnt = 1;
						
//						탐색 가능할 때 까지 한 방향 탐색			
						while(true) {
							ax += dx[k];
							ay += dy[k];
							
							if(ax >= 0 && ax < 19 && ay >=0 && ay < 19) {
								
								if(maps[ax][ay] == maps[i][j]) {
									cnt++;
								}else {
									break;
								}
							}else break;
						}
						ax = i;
						ay = j;
						
//						반대로 돌았을 때 6목이 될 수도 있기 때문에 뒤로 다시 탐색
						while(true) {
							ax -= dx[k];
							ay -= dy[k];
							
							if(ax >= 0 && ax < 19 && ay >=0 && ay < 19) {
								
								if(maps[ax][ay] == maps[i][j]) {
									cnt++;
								}else {
									break;
								}
							}else break;
						}
						
						if(cnt == 5) {
							sb.append(maps[i][j]).append("\n").append((int)i+1 + " " + (int)(j + 1));
							System.out.println(sb);
							return;
						}
					}
				}
			}
		}
		
//		무승부시
		System.out.println(0);
		

	}


}