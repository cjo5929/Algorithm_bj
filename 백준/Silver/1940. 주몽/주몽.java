import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int n, m, cnt, start, end, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

//		투포인터를 위해 정렬
		Arrays.sort(arr);
		start = 0;
		end = n - 1;

//		투포인터
		while (start != end) {
			sum = arr[start] + arr[end];
//			sum 이 목표 값 m보다 작다면 start값 올리기
			if (sum < m) {

				start++;

//			sum 이 목표 값 m보다 크다면 end값 올리기
			} else if (sum > m) {

				end--;

//			같다면 cnt, start 값 올리기
			} else {
				cnt++;
				start++;

			}

		}

//		2중 반복문으로 완탐
//		for(int i = 0; i < n - 1; i++) {
//			for(int j = i + 1; j < n; j++) {
//				if (arr[i] + arr[j] == m) {
//					cnt++;
//				}
//			}
//		}

		System.out.println(cnt);

	}

}