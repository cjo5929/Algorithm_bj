/**
 * @author 강민서
 * @date 2024.02.02
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV14uWl6AF0CFAYD&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=8
 * @keyword_solution  첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다.  이러한 규칙을 가지고 있으므로 큐를 이용하여 풀이
 *  숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료 => 프로그램 종료조건
 * @input 각 수는 integer 범위를 넘지 않는다.
 * @output  8개의 int 데이터 출력
 * @time_complex  O(N)
 * @perf 26,192 kb 147 ms

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, temp;
	static Queue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {

		for (int t = 0; t < 10; t++) {
			int test_case = Integer.parseInt(br.readLine());
			q = new ArrayDeque<>();
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			// 1, 2, 3, 4, 5
			int cnt = 0;
			
			while (true) {
				cnt = ((cnt + 1) % 5);
				if (cnt == 0)
					cnt = 5;

				temp = q.poll() - cnt;
				if (temp <= 0) {
					q.add(0);
					break;
				}

				q.add(temp);

			}
			for(int num : q) {
				sb.append(num + " ");
			}
			
			sb.append("\n");

		}
		System.out.println(sb);
	}

}