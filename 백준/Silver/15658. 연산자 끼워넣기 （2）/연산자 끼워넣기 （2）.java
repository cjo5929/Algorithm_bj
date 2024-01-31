import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 강민서	
 * @date 2024.01.31
 * @link https://www.acmicpc.net/problem/15658
 * @keyword_solution  조건 1. 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. => 수의 순서를 바꾸지 말고 주어진 연산자로 수식 만들기
조건 3. 연산자 우선 순위를 무시하고 앞에서부터 진행 , 
조건 4.  나눗셈은 정수 나눗셈으로 몫만 취한다.
조건 5. 음수를 양수로 나눌 때는양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
 => 가능한 모든 수식을 만들어서 최대 최소 비교하고 출력
 * @input N(2 ≤ N ≤ 11), 연산자 수 합이 N-1보다 크거나 같고, 4N보다 작거나 같은 4개의 정수 => 완탐 가능
 * @output 연산 최대 최소 출력 => 최소 최대가 10억, -10억으로 int가능
 * @time_complex  
 * @perf 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int plus = 0, minus = 1, mul = 2, div = 3; // 스위치 문에는 상수만 들어갈 수 있어서 final
	static int n, max, min;
	static int[] num, operators;
	static boolean[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		operators = new int[4];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		

		dfs(1, num[0]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	static void dfs(int depth, int result) {
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if(operators[i] == 0) continue; //원래 순열의 visited와 비슷함 -> 중복체크
			operators[i]--;  
			 switch (i){
             case plus:
                 dfs(depth + 1, result + num[depth]);
                 break;
             case minus:
                 dfs(depth + 1, result - num[depth]);
                 break;
             case mul:
                 dfs(depth + 1, result * num[depth]);
                 break;
             case div:
                 dfs(depth + 1, result / num[depth]);
                 break;
         }
			 operators[i]++; //원래 순열의 visited와 비슷함 -> 중복체크
		}
	}


}