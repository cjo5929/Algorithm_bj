import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int N;
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		map.put(0 , 0);
		map.put(-1 , 0);
		map.put(1 , 0);
		
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0 , N);
		
		sb.append(map.get(-1) + "\n").append(map.get(0) + "\n").append(map.get(1));
		
		System.out.print(sb);
		
		
	}
	
	static void dfs(int x, int y, int size) {
		
		
		
		if(check(x, y, size)) {
			map.put(arr[x][y], map.get(arr[x][y]) + 1);
			return;
		}else {
			
			int division_size = size / 3;
				
			/**
			 *9개로 자른다
			 * 1 2 3
			 * 4 5 6
			 * 7 8 9
			 */
			
//			1, 2, 3
			dfs(x, y, division_size);
			dfs(x, y + division_size, division_size);
			dfs(x, y + (division_size * 2), division_size);
			
//			4, 5, 6
			dfs(x + division_size, y, division_size);
			dfs(x + division_size, y + division_size, division_size);
			dfs(x + division_size, y + (division_size * 2), division_size);
			
//			7, 8, 9
			dfs(x + (division_size * 2), y, division_size);
			dfs(x + (division_size * 2), y + division_size, division_size);
			dfs(x + (division_size * 2), y + (division_size * 2), division_size);
		}
	}
	
	static boolean check(int x, int y, int size) {
		int value = arr[x][y];
		
		for(int i = x ; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}