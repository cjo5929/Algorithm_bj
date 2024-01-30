/**
 * @author 강민서
 * @date 0129
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV19AcoKI9sCFAZN&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=1&probBoxId=AY0LFFoqrIMDFAXz+#
 * @keyword_solution  메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 것
 * 이 문구에서 제시된 원래 상태와 초기화 상태(0)을 비교해서 달라지는 것이 있다면 카운트를 세고 초기화 값을 변경했다
  원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 => 이 문구에서 원래 상태를 바꾸기 보단 초기 상태가 몇 번 바뀌는지에 초점을 맞춤
 * @input 입력 값 길이는 1 ~ 50
 * @output  int
 * @time_complex  0.11624s
 * @perf 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception
	{

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case);
			String memory = br.readLine();
			char set = '0';
			int cnt = 0;

			for (int i = 0; i < memory.length(); i++) {
                // 초기설정 값이랑 다르다면 cnt++, set을 memory.charAt(i)로 바꿔줌
				if (set != memory.charAt(i)) {
					set = memory.charAt(i);
					cnt++;
				}

			}
			sb.append(" " + cnt).append("\n");
			
		}
        System.out.println(sb);
	}
}