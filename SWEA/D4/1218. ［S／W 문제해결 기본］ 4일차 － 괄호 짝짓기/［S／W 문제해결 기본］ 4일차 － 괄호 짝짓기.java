/**
 * @author 강민서
 * @date 2024.02.02
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV14eWb6AAkCFAYD&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=8
 * @keyword_solution '()', '[]', '{}', '<>' 로 이루어진 문자열 => stack을 통해 괄호 구분 가능
 *  => 알맞은 괄호가 보이면 [] 형태로 같이 stack을 나감 => 결국 stack 마지막에 남아있으면 유효하지 않음
 * @input 문자열 길이와 문자열 입력
 * @output 가능여부 판단 후 0 또는 1 로 출력
 * @time_complex  O(N)
 * @perf 9,136 kb 123 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, temp;
	static ArrayDeque<Character> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t + " ");
			N = Integer.parseInt(br.readLine());
			stack = new ArrayDeque<Character>();
			char[] str = new char[N];

			str = br.readLine().toCharArray();

			for (char s : str) {
				if (s == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (s == '}' && stack.peek() == '{') {
					stack.pop();
				} else if (s == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (s == '>' && stack.peek() == '<') {
					stack.pop();
				}

				else {
					stack.push(s);
				}
			}
			if (stack.isEmpty()) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}

		}
		System.out.println(sb);

	}

}