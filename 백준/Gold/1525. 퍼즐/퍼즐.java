import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayDeque<String> q;
	static Map<String, Integer> map = new HashMap<>();
	static String answer = "123456780";

	public static void main(String[] args) throws IOException {

		String str = "";
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				str += st.nextToken();

			}

		}
		map.put(str, 0);

		if (str.equals(answer)) {
			System.out.println(0);

		} else {
			System.out.println(bfs(str));
		}

	}

	static int bfs(String start) {
		q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {
			String cur = q.poll();
			int idx = cur.indexOf('0');
			int cnt = map.get(cur);
			int px = idx % 3;
			int py = idx / 3;

			if (cur.equals(answer)) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (check(nx, ny)) {
					int nPos = ny * 3 + nx;
//					값 교체
					char c = cur.charAt(nPos);
					String change = cur.replace(c, '.');
					change = change.replace('0', c);
					change = change.replace('.', '0');

//					중복검사
					if (!map.containsKey(change)) {
						q.add(change);
						map.put(change, cnt + 1);
					}

				}
			}

		}

		return -1;

	}

	static boolean check(int x, int y) {
		return x >= 0 && x < 3 && y >= 0 && y < 3;
	}

}