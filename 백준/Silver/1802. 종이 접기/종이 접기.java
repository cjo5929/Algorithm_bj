import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.17
 * @link https://www.acmicpc.net/problem/1802
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
	static int T, mid;
	static String str;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();

			int start = 0;
			int end = str.length() - 1;
			if (flag(start, end)) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		System.out.println(sb.toString().trim());

	}

	static boolean flag(int start, int end) {
		if(start == end) return true;
		
		
		mid = (start + end) / 2;
		
		for(int i = start; i < mid; i++) {
			if(str.charAt(i) == str.charAt(end - i)) {
				return false;
			}
		}
		
		return flag(start, mid - 1);
		
	}

}