/**
 * @author 강민서
 * @date 2024.02.15
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AWXRDL1aeugDFAUo&probBoxId=AY2gBgM6OSIDFAXh&type=PROBLEM&problemBoxTitle=0212%EC%A3%BC&problemBoxCnt=5
 * @keyword_solution  조건에 만족하도록 시뮬레이션
 * @input 10x10 크기에  (20 ≤ M ≤ 100) => 완전탐색 가능 
 * @output 최대값 출력
 * @time_complex O(N)  
 * @perf 21,284 kb 132 ms
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, M, A, sum_result;
	static Point[] step_A;
	static Point[] step_B;
	static int[][] arr = new int[10][10];
	static AP[] ap_list;
	static int[] dx = { 0, -1, 0, 1, 0 }; // 방향 설정 
	static int[] dy = { 0, 0, 1, 0, -1 };

//	배터리센터 좌표, 범위, 성능 저장 클래스
	static class AP {
		int x, y, c, p;

		public AP(int x, int y, int c, int p) {
			this.y = x;
			this.x = y;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException {

//		입력 값 받기
//		#########################################

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			step_A = new Point[M + 1];
			step_B = new Point[M + 1];

			step_A[0] = new Point(1, 1);
			step_B[0] = new Point(10, 10);

			sum_result = 0;
			ap_list = new AP[A];

			st = new StringTokenizer(br.readLine());

//			A가 움직이는 경로 다 넣기
			for (int i = 1; i < M + 1; i++) {
				int dist = Integer.parseInt(st.nextToken());
				step_A[i] = new Point(step_A[i - 1].x + dx[dist], step_A[i - 1].y + dy[dist]);
			}
			
//			B가 움직이는 경로 다 넣기
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M + 1; i++) {
				int dist = Integer.parseInt(st.nextToken());
				step_B[i] = new Point(step_B[i - 1].x + dx[dist], step_B[i - 1].y + dy[dist]);

			}

//			배터리 센터 배열에 담기 
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap_list[i] = new AP(x, y, c, p);

			}
//	      #########################################

//			이동하는 수만큼 반복 
			for (int i = 0; i < M + 1; i++) {
				List<Integer> list_A = new ArrayList<>();
				List<Integer> list_B = new ArrayList<>();


//				이동시 충전 가능한 탑 리스트에 넣기
				for (int j = 0; j < A; j++) {

					if (dist_check(step_A[i].x, ap_list[j].x, step_A[i].y, ap_list[j].y,
							ap_list[j].c)) {
						list_A.add(j);

					}

					if (dist_check(step_B[i].x, ap_list[j].x, step_B[i].y, ap_list[j].y,
							ap_list[j].c)) {
						list_B.add(j);

					}
				}
				
				int result = 0;
//				둘다 충전이 가능한 상태
				if(list_A.size() > 0 && list_B.size() > 0) {
					for(int a : list_A) {
						for(int b : list_B) {
							int sum = 0;
							if(a == b) {
								sum = ap_list[a].p;
							}else {
								sum += ap_list[a].p;
								sum += ap_list[b].p;
							}
							
							result = Math.max(result, sum);
							
						}
					}
					
//				A만 충전이 가능한 상태
				}else if(list_A.size() > 0) {
					for(int a : list_A) {
						if(result < ap_list[a].p) {
							result = ap_list[a].p;
						}
					}
					
//				B만 충전이 가능한 상태
				}else if(list_B.size() > 0) {
					
					for(int b : list_B) {
						if(result < ap_list[b].p) {
							result = ap_list[b].p;
						}
					}
					
				}
				

				sum_result += result;
			}
			
			sb.append(sum_result + "\n");

		}
		System.out.println(sb);

	}

	static boolean dist_check(int x1, int x2, int y1, int y2, int c) {
		if ((Math.abs(x1 - x2) + Math.abs(y1 - y2)) <= c)
			return true;

		return false;
	}

}