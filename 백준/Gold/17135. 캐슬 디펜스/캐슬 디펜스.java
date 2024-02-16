import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, -1, -1 }; // 왼쪽 가운데 오른쪽
	static int[] dy = { -1, 0, 1 };
	static int N, M, D, sum_result, result, minD, minX, minY;
	static int[][] arr, temp;
	static boolean[][] visited;
	static int[] archer_list;
	static boolean game_over;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		temp = new int[N + 1][M];
		archer_list = new int[3];
		sum_result = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = arr[i][j];
			}
		}
		
		
		
		comb(0, 0);

		System.out.println(sum_result);

	}
//	arr 배열 다시 생성
	static void init() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	static void comb(int start, int depth) {
		if(depth == 3) {
			init();
			attack(archer_list);
			return;
		}
		
		for(int i = start; i < M; i++) {
			archer_list[depth] = i;
			comb(start + 1, depth + 1);
		}
	}
	
	static void attack(int[] archer_list) {
		result = 0;
		game_over = false;
		for(int t = 0; t < N; t++) {
			visited = new boolean[N + 1][M];
			for(int k = 0; k < 3; k++) {
				int archer_y = archer_list[k];
				minD = Integer.MAX_VALUE;
				minX = Integer.MAX_VALUE;
				minY = Integer.MAX_VALUE;
				
				for (int i = 1; i <= N; i++) {
					for (int j = 0; j < M; j++) {
						if(arr[i][j] == 1) {
							int dist = dist(i, j, N+1, archer_y);
							if(minD >= dist) {
								
								if(minD > dist) {
									minD = dist;
									minX = i;
									minY = j;
								}else {
									if(minY > j) {
										minX = i;
										minY = j;
									}
								}
							}
						}
					}
				}
//				공격할 수 있는 위치 visited에 true
				if(minD <= D) {
					visited[minX][minY] = true;
				}
				
			}
			
//			공격
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] == true) {
						arr[i][j] = 0;
						result++;
					}
				}
			}
			
//			성 바로 위줄 0으로 초기화 => 공격 끝나고 남은 마지막 줄 적들은 맵 밖으로 나감
			for(int i = 0; i < M; i++) {
				arr[N][i] = 0;
			}
			
//			i - 1 값을 i로 => 적들 한 칸씩 내려오기 
			for (int i = N; i > 0; i--) {
				for (int j = 0; j < M; j++) {
					 arr[i][j] = arr[i - 1][j];
				}
			}
			
			
		}
		sum_result = Math.max(sum_result, result);
	}
	
	static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}