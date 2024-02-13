import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long result, total;
	static long[][] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		total = 0;
		arr = new long[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			total += arr[i][1];
		}

		Arrays.sort(arr, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				if (o1[0] == o2[0]) return (int)(o1[1] - o1[1]);
	
				return (int)(o1[0] - o2[0]);
			}
		});

		long mid = (total + 1) / 2;
		for (long[] point : arr) {
			result += point[1];

			if (result >= mid) {
				sb.append(point[0]);
				break;
			}

		}
		
		System.out.println(sb);

	}

}