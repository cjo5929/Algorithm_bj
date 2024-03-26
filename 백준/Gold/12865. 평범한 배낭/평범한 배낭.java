import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int[][] result, back;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = new int[N + 1][2];
		back = new int[N + 1][K + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			result[i][0] = Integer.parseInt(st.nextToken());
			result[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				int w = result[i][0];
				int v = result[i][1];

				if (j < w) {
					back[i][j] = back[i - 1][j];
				} else {
					back[i][j] = Integer.max(back[i - 1][j], back[i - 1][j - w] + v);
				}

			}
		}
		

		System.out.println(back[N][K]);

	}

}