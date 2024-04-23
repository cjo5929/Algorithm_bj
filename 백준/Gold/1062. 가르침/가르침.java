import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] check = new boolean[26];
	static int n, k, result;
	static String[] words;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		words = new String[n];
		check['a' - 97] = true;
		check['n' - 97] = true;
		check['t' - 97] = true;
		check['i' - 97] = true;
		check['c' - 97] = true;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			words[i] = str;
		}

		dfs(0, 0);
		System.out.println(result);

	}

	static void dfs(int depth, int word) {
		if (depth == k - 5) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				boolean flag = true;
				for (int j = 0; j < words[i].length(); j++) {
					if (!check[words[i].charAt(j) - 97]) {
						flag = false;
						break;
					}
					
				}

				if (flag) {
					cnt++;
				}

			}
			
			result = Math.max(result, cnt);
			return;
		}

		for (int i = word; i < 26; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(depth + 1, i);
				check[i] = false;
			}
		}

	}

}