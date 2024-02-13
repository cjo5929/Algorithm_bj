import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, cnt;
	static char[][] A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new char[N][M];
		B = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			B[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (A[i][j] != B[i][j] && i + 2 < N && j + 2 < M) {

					for (int x = i; x < i + 3; x++) {
						for (int y = j; y < j + 3; y++) {
							A[x][y] = A[x][y] == '1' ? '0' : '1';
						}
					}

					cnt++;

				}

			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}

			}
		}

		System.out.println(cnt);
	}

}