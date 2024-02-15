import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long answer, temp;
	static int N;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		if (N % 2 == 0) {
			for (int i = 0; i < N / 2; i++) {
				temp = arr[i] + arr[N - i - 1];
				answer = Math.max(answer, temp);
			}
		} else {
			answer = arr[N - 1];
			for (int i = 0; i < N / 2; i++) {
				temp = arr[i] + arr[N - i - 2];
				answer = Math.max(answer, temp);
			}

		}

		System.out.println(answer);

	}

}