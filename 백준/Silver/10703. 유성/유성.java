import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int r, s, len;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new char[r][s];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < s; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		len = Integer.MAX_VALUE;

		for (int i = 0; i < s; i++) {
			int star_index = -1;
			int ground_index = -1;
			for (int j = 0; j < r; j++) {
				if (arr[j][i] == 'X') {
					star_index = j;
				}

				if (arr[j][i] == '#' && star_index != -1) {
					ground_index = j;
					break;
				}
			}
			if (star_index != -1 && ground_index != -1) {
				len = Math.min(len, ground_index - star_index - 1);
			}
		}

		for(int i = 0; i < s; i++) {
			for(int j = r - 1; j >= 0; j--) {
				if(arr[j][i] == 'X'){
					arr[j][i] = '.';
					arr[j+len][i] = 'X';
				}
			}
		}

		for(int i = 0; i < r; i++) {
			for(int j = 0; j < s; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}