/**
 * @author 강민서
 * @date 2024.02.03
 * @link https://www.acmicpc.net/problem/11279
 * @keyword_solution  최대힙 -> 우선순위 큐의 정렬 기준을 최대값으로 교체 
 * @input N(1≤N≤100,000)
 * @output 0을 입력 받으면 출력 -> StringBuilder로 한 번에 출력
 * @time_complex  O(NlogN)
 * @perf 25412 340
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, NUM;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
//			절댓값으로 우선순위 큐 기준을 변경하기 위해 compare 오버라이드 
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2) * -1;
			}
		});

//		우선순위 큐의 정렬 기준을 절댓값 오름차순으로 변경하고 코드 진행
		for (int i = 0; i < N; i++) {
			NUM = Integer.parseInt(br.readLine());

			if (NUM == 0) {
				if (priorityQ.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(priorityQ.poll()).append("\n");
				}
			} else {
				priorityQ.offer(NUM);
			}
		}

		System.out.println(sb);
	}

}