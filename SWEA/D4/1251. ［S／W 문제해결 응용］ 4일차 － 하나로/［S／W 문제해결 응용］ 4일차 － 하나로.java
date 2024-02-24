/**
 * @author 강민서
 * @date 2024.02.23
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV15StKqAQkCFAYD&probBoxId=AY3JcG16dgMDFAXh&type=PROBLEM&problemBoxTitle=0219%EC%A3%BC&problemBoxCnt=4&&&&&&
 * @keyword_solution 해저터널을 연결하여 최소신장트리를 구성  
 * @input  (1≤N≤1,000),(0≤X≤1,000,000, 0≤Y≤1,000,000).
 * @output 소수 첫째 자리에서 반올림하여 정수 형태로 출력
 * @time_complex  
 * @perf 147,688 kb 943 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int 테스트케이스수, 섬의개수;
	static double 세율;
	static long 결과;
	static int[] parent, x, y;
	static ArrayList<터널>[] 인접리스트;
	static boolean[] 연결여부;
	static PriorityQueue<터널> 큐;

	static class 터널 implements Comparable<터널> {
		int 위치;
		long 환경부담금;

		public 터널(int 위치, long 환경부담금) {
			this.위치 = 위치;
			this.환경부담금 = 환경부담금;
		}

		@Override
		public int compareTo(터널 o) {
			return Long.compare(this.환경부담금, o.환경부담금);

		}

		@Override
		public String toString() {
			return "터널 [연결섬=" + 위치 + ", 환경부담금=" + 환경부담금 + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		테스트케이스수 = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= 테스트케이스수; test_case++) {
			sb.append("#" + test_case + " ");

			섬의개수 = Integer.parseInt(br.readLine());
			x = new int[섬의개수];
			y = new int[섬의개수];
			인접리스트 = new ArrayList[섬의개수];
			연결여부 = new boolean[섬의개수];

			for (int i = 0; i < 섬의개수; i++) {
				인접리스트[i] = new ArrayList<>();
			}

//			x 좌표 입력 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 섬의개수; i++) {

				x[i] = Integer.parseInt(st.nextToken());
			}

//			y 좌표 입력 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 섬의개수; i++) {

				y[i] = Integer.parseInt(st.nextToken());
			}
//			세율
			세율 = Double.parseDouble(br.readLine());

//			환경부담금 계산해서 완전 연결리스트 생성
			for (int i = 0; i < 섬의개수 - 1; i++) {
				for (int j = i + 1; j < 섬의개수; j++) {

					long X거리 = Math.abs(x[i] - x[j]);
					long Y거리 = Math.abs(y[i] - y[j]);
					인접리스트[i].add(new 터널(j, 세율계산(X거리, Y거리)));
					인접리스트[j].add(new 터널(i, 세율계산(X거리, Y거리)));
				}
			}

			결과 = 0;
			프림(0);

			sb.append(Math.round(결과 * 세율) + "\n");
		}
		System.out.println(sb);

	}

	static void 프림(int 시작점) {
		큐 = new PriorityQueue<>();
		큐.offer(new 터널(시작점, 0));

		while (!큐.isEmpty()) {
			터널 현재섬 = 큐.poll();
			int 현재위치 = 현재섬.위치;
			double 환경부담금 = 현재섬.환경부담금;

			if (연결여부[현재위치])
				continue;
			연결여부[현재위치] = true;
			결과 += 환경부담금;

			for (int i = 0; i < 인접리스트[현재위치].size(); i++) {
				터널 다음섬 = 인접리스트[현재위치].get(i);

				int 다음섬위치 = 다음섬.위치;
				long 다음섬_환경부담금 = 다음섬.환경부담금;

				if (!연결여부[다음섬위치]) {
					큐.offer(new 터널(다음섬위치, 다음섬_환경부담금));
				}

			}
		}

	}

	static long 세율계산(long X거리, long Y거리) {
		return (long) ((Math.pow(X거리, 2) + (Math.pow(Y거리, 2))));
	}

}