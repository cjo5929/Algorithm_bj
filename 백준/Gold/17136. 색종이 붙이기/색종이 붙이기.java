import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int result;
	static int[][] arr = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		result = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			
			System.out.println(result);
		}
	}

	static void dfs(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(result <= cnt) return;


		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}

		if (arr[x][y] == 1) {
			for (int i = 1; i <= 5 ; i++) {
				if (paper[i] > 0 && possible(x, y, i)) {
					attach(x, y, i, 0);
					paper[i]--;
					dfs(x, y + 1, cnt + 1);
					attach(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}

	}

	static void attach(int x, int y, int size, int num) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = num;

			}
		}
	}

	static boolean possible(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (!check(i, j))
					return false;
				
				if(arr[i][j] == 0) return false;
			}
		}

		return true;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < 10 && y >= 0 && y < 10;
	}

}