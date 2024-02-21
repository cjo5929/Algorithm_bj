/**
 * 다시 풀어볼 문제
 * @author 강민서
 * @date 2024.02.21
 * @link https://www.acmicpc.net/problem/15683
 * @keyword_solution 시뮬레이션
 * @input (1 ≤ N, M ≤ 8)
 * @output 최소 크기 출력 
 * @time_complex  
 * @perf 87796	288
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static int[][][] mode = { { { 0 } }, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 2, 3 }, { 0, 1 } },
			{ { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } }, { { 0, 2, 3 }, { 0, 1, 3 }, { 1, 2, 3 }, { 0, 1, 2 } },
			{ { 0, 1, 2, 3 } } };

	static int N, M, result, zero;
	static int[][] arr;
	static ArrayList<CCTV> list = new ArrayList<>();

	static class CCTV {
		int x, y, type;

		public CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					list.add(new CCTV(i, j, arr[i][j]));
				}else if(arr[i][j] == 0) zero++;
			}
		}
		
		result = zero;
		dfs(0, arr);
		System.out.println(result);
	}
	static void dfs(int depth, int[][] map) {
		
		if(depth == list.size()) {
			int cnt = count(map);
			
			result = Math.min(result, cnt);
			return;
		}
		
		int type = list.get(depth).type;
		int x = list.get(depth).x;
		int y = list.get(depth).y;
		
		for(int i = 0; i < mode[type].length; i++) {
			int[][] copy_map = new int[N][M];
			
			for(int k = 0; k < N; k++) {
				copy_map[k] = Arrays.copyOf(map[k], M);
			}
			
			for(int j = 0; j < mode[type][i].length; j++) {
				int dir = mode[type][i][j];
				
				int ax = x + dx[dir];
				int ay = y + dy[dir];
				
				while(true) {
					if(!check(ax, ay) || arr[ax][ay] == 6) break;
					
					copy_map[ax][ay] = -1;
					
					ax += dx[dir];
					ay += dy[dir];
				}
			}
			
			dfs(depth + 1, copy_map);
		}
		
	}
	
	static boolean check(int ax, int ay) {
		return (ax >= 0 && ax < N && ay >= 0 && ay < M);
	}
	
	static int count(int [][] copy_map) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copy_map[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
		
	}

}