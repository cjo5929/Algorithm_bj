import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, result;
	static boolean[] visited;
	static int[] arr, parents;
	static ArrayDeque<Integer> q;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		arr = new int[n];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n - 1; i++) {
			if(find(arr[i]) != find(arr[i + 1])) result++;
		}
		
		System.out.println(result);

	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x > y) {
			parents[x] = y;
		} else {
			parents[y] = x;
		}
	}

	static int find(int x) {
		if(parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
}