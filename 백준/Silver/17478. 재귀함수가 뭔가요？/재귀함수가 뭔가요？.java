import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 강민서
 * @date 0129
 * @link https://www.acmicpc.net/problem/17478
 * @keyword_solution  ________라고 답변하였지. => 뒤에 점점 _가 줄고 라고 답변하였지만 반복하는거 보니 재귀호출 하는 함수 뒤에 쓰여짐
 * "____"재귀함수가 뭔가요?"
____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.""
가 반복되는거 보니 재귀호출 안에 있음 => ____를 추가하면서 돌기
n == 0이 될 때 멈춤
 * @input N(1 ≤ N ≤ 50)
 * @output String
 * @time_complex  (n)
 * @perf 14828kb 156ms
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		String s ="";
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		chat(n, s);
	}
	
	static void chat(int n, String s) {
		if(n == 0) {
			System.out.println(s + "\"재귀함수가 뭔가요?\"");
			System.out.println(s + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(s + "라고 답변하였지.");
			return;
		}
		
		System.out.println(s + "\"재귀함수가 뭔가요?\"");
        System.out.println(s + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(s + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(s + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		chat(n - 1, s +"____");
		System.out.println(s + "라고 답변하였지.");
	}
	
}