/**
 * @author 강민서
 * @date 2024.02.15
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV15OZ4qAPICFAYD&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0212%EC%A3%BC&problemBoxCnt=5&probBoxId=AY2gBgM6OSIDFAXh
 * @keyword_solution  여러분은 모든 가능한 경로를 살펴서 해를 찾아도 좋다. => 순열을 활용해서 모든 경우의 수 구하기 
 * @input 2≤N≤10 => N! 순열로 통과하기에는 충분함
 * @output 최단 경로의 이동거리
 * @time_complex  O(N!)
 * @perf 21,084 kb 1,702 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, result, min_answer;
	static Node[] arr, copied;
	static boolean[] visitied;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		입력 값 받기
//		#########################################

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(br.readLine());
			arr = new Node[N + 2];
			copied = new Node[N];
			min_answer = Integer.MAX_VALUE;
			visitied = new boolean[N + 2];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N + 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = new Node(x, y);
			}
//	      #########################################

			visitied[0] = true;
			visitied[1] = true;
			permutation(0, visitied);
			sb.append(min_answer + "\n");
		}

		System.out.println(sb);
	}

	public static void permutation(int depth, boolean[] visited) {

		if (depth == N) {
			calc(copied);
			min_answer = Math.min(min_answer, result);
			return;
		}

		for (int i = 2; i < N + 2; i++) {
			if (!visited[i]) {
				visited[i] = true;
				copied[depth] = arr[i];
				permutation(depth + 1, visited);
				visited[i] = false;
			}
		}
	}

	public static void calc(Node[] p) {
		result = Math.abs(arr[0].x - p[0].x) + Math.abs(arr[0].y - p[0].y);
		result += Math.abs(arr[1].x - p[N - 1].x) + Math.abs(arr[1].y - p[N - 1].y);

		for (int i = 0; i < N - 1; i++) {

			result += Math.abs(p[i].x - p[i + 1].x) + Math.abs(p[i].y - p[i + 1].y);

		}
	}
}