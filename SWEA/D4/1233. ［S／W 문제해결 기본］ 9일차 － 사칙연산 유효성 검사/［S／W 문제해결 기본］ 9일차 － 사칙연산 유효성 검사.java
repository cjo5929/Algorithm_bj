/**
 * @author 강민서
 * @date 2024.02.06
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV141176AIwCFAYD&probBoxId=AY13IwlKMEcDFAWX&type=PROBLEM&problemBoxTitle=0205%EC%A3%BC&problemBoxCnt=3
 * @keyword_solution  유효성이란, 사칙연산 “+, -, *, /”와 양의 정수로 구성된 임의의 식이 적절한 식인지를 확인하는 것
 * => 연산자 다음 자식 노드에 연산자가 들어오지 않고 자식 노드가 없다면 불가능 !
 * @input 총 노드의 개수는 200개를 넘어가지 않는다. => 완탐 가능
 * @output 단순하게 int형으로 가능하면 1, 불가능이면 0
 * @time_complex  O(N)
 * @perf 18,888 kb 122 ms

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, T;
	static int result;
	static ArrayList<Character> oper = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			N = Integer.parseInt(br.readLine());
			result = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char a = st.nextToken().charAt(0);
				if(oper.contains(a) && st.countTokens() != 2) {
					result = 0;
				}else if(!oper.contains(a) && st.hasMoreTokens()) {
					result = 0;
				}
				

			}
			
			sb.append(result + "\n");
		}

		System.out.println(sb);

	}

}