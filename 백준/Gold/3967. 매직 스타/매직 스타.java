import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[][] arr;
	static int x_cnt;
	static ArrayList<Point> blank = new ArrayList<Point>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		arr = new char[5][9];
		visited = new boolean[12];

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'x') {
					blank.add(new Point(i, j));
				} else if (arr[i][j] != '.') {
					visited[arr[i][j] - 65] = true; // 해당 숫자들은 고정이므로 true
				}
			}
		}

		permu(0);
	}

	static void permu(int depth) {

		if (depth == blank.size()) {
			if (check()) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}
				
				System.exit(0);
			}
			
			return;
		}

		for (int i = 0; i < 12; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[blank.get(depth).x][blank.get(depth).y] = (char) (65 + i);
				permu(depth + 1);
				visited[i] = false;
			}
		}
	}

	static boolean check() {
		int sum1 = (arr[0][4]-'A'+1) + (arr[1][3]-'A'+1)+ (arr[2][2]-'A'+1)+(arr[3][1]-'A'+1);
        int sum2 = (arr[0][4]-'A'+1)+(arr[1][5]-'A'+1)+(arr[2][6]-'A'+1)+(arr[3][7]-'A'+1);
        int sum3 = (arr[1][1]-'A'+1)+(arr[1][3]-'A'+1)+(arr[1][5]-'A'+1)+(arr[1][7]-'A'+1);
        int sum4 = (arr[3][1]-'A'+1)+(arr[3][3]-'A'+1)+(arr[3][5]-'A'+1)+(arr[3][7]-'A'+1);
        int sum5 = (arr[4][4]-'A'+1)+(arr[3][3]-'A'+1)+(arr[2][2]-'A'+1)+(arr[1][1]-'A'+1);
        int sum6 = (arr[4][4]-'A'+1)+(arr[3][5]-'A'+1)+(arr[2][6]-'A'+1)+(arr[1][7]-'A'+1);
        
        
		return (sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26);
	}

}