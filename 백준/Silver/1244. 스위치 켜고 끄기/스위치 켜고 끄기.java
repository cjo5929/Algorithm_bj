import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 0130
 * @link https://www.acmicpc.net/problem/1244
 * @keyword_solution 
 * 조건 1 : 나와있는 조건을 보면 남자 일 때 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
 * 조건 2 : 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
 * 조건 3 : 예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다.
         
 *                   
 * @input
 * 스위치는 100 이하인 양의 정수, 학생수는 100 이하인 양의 정수 이므로 완전탐색을 해도 문제 없음
 * @output
 * 출력 값이 크지 않아 sysout으로 출력
 * @time_complex 14652	152
 * @perf 14652kb 152ms
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, r;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				arr[i] = true;
			}

		}
		int students = Integer.parseInt(br.readLine());
		for (int i = 0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

//			남자일 때 
			if (k == 1) {
				for (int s = 0; s < n; s++) {
					if ((s+1) % num == 0) {
						arr[s] = !arr[s];
					}
				}
				

//          여자일 때
			} else

			{
//				번호에 해당하는 스위치는 무조건 바뀜
				arr[num - 1] = !arr[num - 1];
				
//				대칭이므로 반복수를 n/2만큼
				for (int s = 1; s < n / 2; s++) {

					if ((num - s - 1) < 0 || (num + s - 1) >= n)
						break;
					else {
						if (arr[num - s - 1] == arr[num + s - 1]) {
							arr[num - s - 1] = !arr[num - s - 1];
							arr[num + s - 1] = !arr[num + s - 1];
						}else break; // 좌우 대칭이 아닌 순간 벗어남
					}

				}

			}

		}
		for(int i = 1; i <= arr.length; i++) {
			int result = arr[i - 1] ? 1 : 0;
			System.out.print(result + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		
	}

}