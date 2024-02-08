import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, L, result;
	static int[] point, cal;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			point = new int[N];
			cal = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());

			}
			
			result = 0;

			powerSet(0, 0, 0);
			sb.append(result + "\n");

		}
		System.out.println(sb);

	}

	static void powerSet(int depth, int point_sum, int cal_sum) {

		if (cal_sum > L)
			return;

		if (depth == N) {
			
            if(point_sum > result) {
                result = point_sum;
              
            }
//			result = Math.max(result, point_sum);
            return;
		}

		
		powerSet(depth + 1, point_sum + point[depth], cal_sum + cal[depth]);

		powerSet(depth + 1, point_sum, cal_sum);

	}

}