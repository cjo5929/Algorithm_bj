/**
 * @author 강민서
 * @date 2024.02.13
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWgv9va6HnkDFAW0&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0212%EC%A3%BC&problemBoxCnt=1&probBoxId=AY2gBgM6OSIDFAXh&&&&&
 * @keyword_solution  규영이가 내는 카드의 순서를 고정 => 인영이가 낼 수 있는 카드의 수를 뽑는다(순열)
 * 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성 => 하나하나 비교하면서 카운트하기
 * @input 각 정수는 1이상 18이하, 9개의 카드 -> 최대 9! 완전탐색 가능 
 * @output swea기본 출력
 * @time_complex 20,728 kb 3,387 ms 
 * @perf O(9!)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, total, gu0_point, in0_point, win, defeat;
	static int card = 18;
	static int n = 9;
	static int[] gu0 = new int[9];
	static int[] in0 = new int[9];
	static int[] list = new int[9];
	static boolean[] deck;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		total = 362880;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			deck = new boolean[card + 1];
			int idx = 0;
			in0 = new int[9];
			visited = new boolean[n];
			gu0_point = 0;
			in0_point = 0;
			win = 0;

			for (int i = 0; i < 9; i++) {
				gu0[i] = Integer.parseInt(st.nextToken());
				deck[gu0[i]] = true;
			}

			for (int i = 1; i <= card; i++) {
				if (!deck[i]) {
					in0[idx++] = i;
				}
			}

			permutation(0);
			sb.append(win + " " + (total - win) + "\n");

		}
		System.out.println(sb);
	}

	static void permutation(int depth) {
		if (depth == n) {
			gu0_point = 0;
			in0_point = 0;
			calc(list);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list[depth] = in0[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}

	static void calc(int[] list) {
		for (int i = 0; i < n; i++) {
			if (gu0[i] > list[i]) {
				gu0_point += gu0[i] + list[i];
			} else {
				in0_point += gu0[i] + list[i];
			}
		}

		if (gu0_point > in0_point)
			win++;

	}

}