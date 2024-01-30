import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.01.30
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV7GLXqKAWYDFAXB&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=4
 * @keyword_solution 
 * 조건 1. N X N 농장의 크기는 항상 홀수 
 * 조건 2. 수확은 정사각형 마름모 형태로 => start, end 좌표를 n / 2초기화 해서 범위 계산 => 마름모 모형은 도형 중간에서 넓어지고 좁아지는 것을 이용 
 * 조건 3. 배열마다 농작물의 가치가 있음 그것을 SUM
 * 
 * @input N은 1 이상 49 이하의 홀수 => 완전탐색을 해도 가능
 *  => 숫자열이 붙어 있어서 toCharArray로 char배열에 담고 나중에 sum 할 때는 - '0'
 * @output 수익을 출력 => 신경 안 써도 될 것 같음
 * @time_complex O(n^2)
 * @perf 20,532 kb, 120 ms
 */

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, start, end, sum;
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case + " ");
			int n = Integer.parseInt(br.readLine());
			arr = new char[n][n];

			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();

			}
			start = n / 2;
			end = n / 2;
			sum = 0;
			

			for (int i = 0; i < n; i++) {
				for (int j = start; j <= end; j++) {

					sum += arr[i][j] - '0';


				}
				if (i >= (n / 2)) {
					start++;
					end--;
				} else {
					start -= 1;
					end += 1;
				}
			}

			sb.append(sum + "\n");

		}
		System.out.println(sb);

	}

}