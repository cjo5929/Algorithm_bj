import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.bind.ParseConversionEvent;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, tc;
	static Map<String, Integer> map;
	static Integer[] parent;
	static int[] cnt;
	static Set<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = 0;
		while (true) {
			map = new HashMap<>();
			tc++;
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			sb.append(tc + " ");
			parent = new Integer[N];
			cnt = new int[N];

			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}

			int index = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!map.containsKey(a)) {
					map.put(a, index++);
				}

				if (!map.containsKey(b)) {
					map.put(b, index++);
				}

				union(map.get(a), map.get(b));

			}
			set = new HashSet<>(Arrays.asList(parent));
			sb.append(set.size() + "\n");

		}

		System.out.println(sb.toString().trim());
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}

	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

}