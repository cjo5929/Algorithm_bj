import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.01
 * @link https://www.acmicpc.net/problem/15565
 * @keyword_solution 라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기 => 슬라이딩 위도우 사용
 * @input (1 ≤ K ≤ N ≤ 10^6) => for 문 2개를 써서 완탐을 할 경우 시간 초과 => O(N)으로 풀어야함
 * @output 비밀번호의 종류의 수를 출력 -> int형 가능
 * @time_complex O(N)
 * @perf 21972 320
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K;
	static List<Integer> lions;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		lions = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			;
			if (Integer.parseInt(st.nextToken()) == 1) {
				lions.add(i);
			}
		}

		if (lions.size() < K) {
			sb.append(-1);
			System.out.println(sb);
			return;
		}

		int start = 0;
		int end = K - 1;
		int min = Integer.MAX_VALUE;

		while (end < lions.size()) {
			min = Math.min(min, lions.get(end) - lions.get(start) + 1);

			start++;
			end++;

		}

		sb.append(min);

		System.out.println(sb);

	}

}