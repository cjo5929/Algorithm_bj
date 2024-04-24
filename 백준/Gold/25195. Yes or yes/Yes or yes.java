import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, s;
	static ArrayList<Integer>[] list;
	static boolean[] fan;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		fan = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m; i++) {

			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list[start].add(end);
		}

		s = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < s; i++) {
			fan[Integer.parseInt(st.nextToken())] = true;
		}
		flag = false;
		dfs(1);

		if (flag) {
			System.out.println("yes");
		} else {
			System.out.println("Yes");
		}
	}

	static void dfs(int x) {
		if(fan[x]) return;
		
		if(list[x].isEmpty()) {
			flag = true;
			return;
		}

		for (int i = 0; i < list[x].size(); i++) {
			int next = list[x].get(i);
			if (!list[next].isEmpty()) {

				dfs(next);

			} else {
				if (!fan[next]) {
					flag = true;

				}
			}

		}

	}

}