/**
 * @author 강민서
 * @date 2024.02.05
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV14w-rKAHACFAYD&probBoxId=AY13IwlKMEcDFAWX&type=PROBLEM&problemBoxTitle=0205%EC%A3%BC&problemBoxCnt=1
 * @keyword_solution  앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입 => 삽입할 위치에 숫자를 삽입하고 원래 있던 숫자는 뒤로 밀려나가도록 해야함
 * => 정적인 배열로 하기에는 크기도 가변적이고 원하는 위치에 삽입하기 시간이 오래걸리고 구현이 어려움 => 크기가 가변적이고 데이터 삽입이 쉬운 LinkedList로 접근
 * @input 원본 : N ( 10 ≤ N ≤ 20 의 정수) 명령어 : ( 5 ≤ N ≤ 10 의 정수) 
 * @output   공백 문자 후 수정된 암호문의 처음 10개 항을 출력 => 10개 항 주의
 * @time_complex  O(N)
 * @perf 18,604 kb 113 ms

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K, x, y;
	static List<String> original;
	static int T = 10;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			original = new LinkedList<>(); // LinkedList 선언
			
			for(int i = 0; i < N; i++) {
				original.add(st.nextToken());
			}

			K = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < K; i++) {
				
				st.nextToken(); // I는 필요없음
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				int idx = x;
				for(int j = 0; j < y; j++) { // y개의 숫자 만큼
					String s = st.nextToken();
					
					original.add(idx++, s); // idx위치에 삽입 후 idx 증가
				}
			}
			
			for(int i = 0; i < 10; i++) { // 10개만 출력
				sb.append(original.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		
	}

}