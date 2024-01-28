import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
				sb.append(" ");
			}

			for (int j = 0; j < 2 * i + 1; j++) {
				sb.append("*");
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}


}