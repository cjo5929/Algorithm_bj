import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, r;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		combi(new int[r], 0, 0);
		System.out.println(sb);

	}

	static void combi(int[] copy, int depth, int start) {
		if (depth == r) {
			for (int i : copy) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < n; i++) {
			copy[depth] = arr[i];
			combi(copy, depth + 1, i);

		}
	}

}