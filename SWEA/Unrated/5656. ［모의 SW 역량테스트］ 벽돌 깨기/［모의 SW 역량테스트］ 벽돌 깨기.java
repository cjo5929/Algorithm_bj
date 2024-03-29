import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, W, H, result;
	static int[][] arr, copy;
	static int[] ball;
	static boolean[] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Wall {
		int x;
		int y;
		int power;

		public Wall(int x, int y, int power) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
		}

		@Override
		public String toString() {
			return "Wall [x=" + x + ", y=" + y + ", power=" + power + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			arr = new int[H][W];
			copy = new int[H][W];
			visited = new boolean[W];
			ball = new int[N];
			result = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = arr[i][j];
				}
			}
			


			permu(0);
			sb.append(result + "\n");
		}
		System.out.println(sb);

	}

//	공 떨어지는 위치 순열로 모두 구함
	static void permu(int depth) {
		if (depth == N) {
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < H; j++) {
					if (arr[j][ball[i]] != 0) {
						y = ball[i];
						x = j;
						break;
					}
				}

				broken(x, y);
				down();
			}
			
			int cnt = count();

			result = Math.min(result, cnt);
			
			copy_arr();
			
			return;
		}

		for (int i = 0; i < W; i++) {
			if (!visited[i]) {
				ball[depth] = i;
				permu(depth + 1);
				visited[i] = false;
			}
		}
	}

	// 벽돌 깨기
	static void broken(int x, int y) {
		Queue<Wall> q = new ArrayDeque();
		q.add(new Wall(x, y, arr[x][y]));
		arr[x][y] = 0;

		while (!q.isEmpty()) {
			Wall cur = q.poll();
			int power = cur.power;

			// 블록의 숫자만큼 반복
			for (int i = 1; i < power; i++) {
				for (int j = 0; j < 4; j++) {
					int ax = cur.x + dx[j] * i;
					int ay = cur.y + dy[j] * i;

					if (check(ax, ay) && arr[ax][ay] != 0) {
						q.add(new Wall(ax, ay, arr[ax][ay]));
						arr[ax][ay] = 0;
					}
				}
				
			}
		}
	}
	
	// 벽돌 내리기
	static void down() {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				if(arr[j][i] != 0) {
					stack.push(arr[j][i]);
				}
			}
			
			for(int k = H - 1; k >= 0; k--) {
				if(!stack.isEmpty()) {
					arr[k][i] = stack.pop();
				}else {
					arr[k][i] = 0;
				}
			}
		}
		

	}
	
//	남은 벽돌 수 세기
	static int count() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(arr[i][j] != 0) {
					cnt++;
				}

			}
		}
		
		return cnt;
	}
	
//	배열 복사
	static void copy_arr() {
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = copy[i][j];
			}
		}
	}
	

//	배열 체크
	static boolean check(int cx, int cy) {
		return cx >= 0 && cx < H && cy >= 0 && cy < W;
	}

}