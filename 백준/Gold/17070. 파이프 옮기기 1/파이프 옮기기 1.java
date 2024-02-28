import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, cnt, index, ax, ay;
	static int[][] arr;
	static int[][] result = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
	static int[] width = { 0, 1 };
	static int[] diagonal = { 1, 1 };
	static int[] height = { 1, 0 };

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		dfs(0, 1, 0);
		System.out.println(cnt);
		
	}

	static void dfs(int x, int y, int dist) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}

		switch (dist) {
		case 0:
			ax = x + result[0][0];
			ay = y + result[0][1];
			
			
			
			if (check(ax, ay) && arr[ax][ay] == 0) {
				dfs(ax, ay, 0);
			}

			ax = x + result[1][0];
			ay = y + result[1][1];

			if (check(ax, ay) && diagonalCheck(ax, ay)) {
				dfs(ax, ay, 1);
			}

			break;

		case 1:
			ax = x + result[0][0];
			ay = y + result[0][1];
			
			

			if (check(ax, ay) && arr[ax][ay] == 0) {
				dfs(ax, ay, 0);
			}

			ax = x + result[1][0];
			ay = y + result[1][1];

			if (check(ax, ay) && diagonalCheck(ax, ay)) {
				dfs(ax, ay, 1);
			}

			ax = x + result[2][0];
			ay = y + result[2][1];

			if (check(ax, ay) && arr[ax][ay] == 0) {
				dfs(ax, ay, 2);
			}

			break;

		case 2:
			ax = x + result[2][0];
			ay = y + result[2][1];

			if (check(ax, ay) && arr[ax][ay] == 0) {
				dfs(ax, ay, 2);
			}

			ax = x + result[1][0];
			ay = y + result[1][1];

			if (check(ax, ay) && diagonalCheck(ax, ay)) {
				dfs(ax, ay, 1);
			}

			break;
			
		
		}

	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < N;
	}
	
	static boolean diagonalCheck(int ax, int ay) {
		return arr[ax - 1][ay] == 0 && arr[ax][ay - 1] == 0 && arr[ax][ay] == 0;
	}
}