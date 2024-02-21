/**
 * @author 강민서
 * @date 2024.02.21
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWBJKA6qr2oDFAWr&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0219%EC%A3%BC&problemBoxCnt=1&probBoxId=AY3JcG16dgMDFAXh
 * @keyword_solution 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산
 * => 유니온 파인드 연산을 말함  
 * @input n(1≤n≤1,000,000), m(1≤m≤100,000)
 * @output  1을, 아니면 0을 출력
 * @time_complex O(N)
 * @perf 101,348 kb 445 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, T, command, a, b;
	static int result;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];
			
//			유니온파인드 배열 자기 자신으로 초기화
			for(int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				command = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				if(command == 0) {
					union(a, b);
					continue;
				}
				
				if(find(a) == find(b)) {
					sb.append(1);
				}else {
					sb.append(0);
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

//	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

}