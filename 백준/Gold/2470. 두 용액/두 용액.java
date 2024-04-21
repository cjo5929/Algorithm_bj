import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, start, end;
	static long result;
	static long[] arr, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		answer = new long[2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		start = 0;
		end = n - 1;
		result = Long.MAX_VALUE;

		while (start < end) {
			long sum = arr[start] + arr[end];

			if (result > Math.abs(sum)) {

				result = Math.abs(sum);

				answer[0] = arr[start];
				answer[1] = arr[end];

				if (sum == 0) {
					break;
				}
			}
			
			if(sum < 0) {
				start++;
			}else {
				end--;
			}

		}
		
		System.out.println(answer[0] + " " + answer[1]);

	}

}