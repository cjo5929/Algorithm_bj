import java.awt.Point;

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
	static int[][] arr;
	static ArrayList<Point> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';

				if (arr[i][j] == 0) {
					list.add(new Point(i, j));
				}
			}

		}

//		for(int i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//			
//		}

		sudo(0);


	}

	static void sudo(int depth) {
		if (list.size() == depth) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();

			}
			System.exit(0);
			return;
		}

		int x = list.get(depth).x;
		int y = list.get(depth).y;

		boolean[] sudoNum = new boolean[10];

//		가로
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] != 0) {
				sudoNum[arr[x][i]] = true;
			}
		}

//		세로
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] != 0) {
				sudoNum[arr[i][y]] = true;
			}
		}

//		사각형
		int start_x = (x / 3) * 3;
		int start_y = (y / 3) * 3;

		for (int i = start_x; i < start_x + 3; i++) {
			for (int j = start_y; j < start_y + 3; j++) {
				if (arr[i][j] != 0) {
					sudoNum[arr[i][j]] = true;
				}
			}
		}
		

		for (int i = 1; i < 10; i++) {
			if (!sudoNum[i]) {
				arr[x][y] = i;
				sudo(depth + 1);
				arr[x][y] = 0;
			}
			
		}
		
		
		
	}

}