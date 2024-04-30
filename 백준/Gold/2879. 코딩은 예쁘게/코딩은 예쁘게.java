import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, result;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) - arr[i];
		}

//		System.out.println(Arrays.toString(arr));
		int current = arr[0];
		int max_cnt = 0;

		for (int i = 1; i < n; i++) {
//			부호가 다를 경우(추가 삭제 다른 편집)
//			System.out.println(max_cnt + " " + result);
			if (current * arr[i] < 0) {

				result += Math.abs(current);
				
//				부호가 같을 경우 (같은 편집)
			} else if (Math.abs(current)  >=  Math.abs(arr[i])) {
				result += Math.abs(Math.abs(current) - Math.abs(arr[i]));

			}
			
			current = arr[i];
		}
		

		System.out.println(result + Math.abs(current));

	}

}