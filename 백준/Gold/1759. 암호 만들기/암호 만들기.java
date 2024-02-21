/**
 * @author 강민서
 * @date 2024.02.21
 * @link https://www.acmicpc.net/problem/1759
 * @keyword_solution  
 * 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음 => 조합 구성 시 조건 
 * 알파벳이 암호에서 증가하는 순서로 배열 => 정렬 한 뒤 조합 구성
 * => 가능한 조합 수 구하고 조건 검사
 * @input (3 ≤ L ≤ C ≤ 15) => 2^15 * L => 2초 내에 완전탐색 가능
 * @output 암호 출력
 * @time_complex  14288	124
 * @perf O(2^L)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static ArrayList<Character> gather = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	static char[] list;
	static char[] password;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new char[C];
		password = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			list[i] = st.nextToken().charAt(0);
		}

//		정렬
		Arrays.sort(list);

		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int start, int depth) {

		if (depth == L) { 

			if (check()) {
				for (char a : password) {
					sb.append(a);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			password[depth] = list[i];
			comb(i + 1, depth + 1);
		}
	}

//	암호문 조건 검사
	static boolean check() {
		int consonant = 0;
		boolean flag = false;
		
		for (char a : password) {
			if (gather.contains(a)) {
				flag = true;
			}else {
				consonant++;
			}
		}
		
		return (flag && consonant >= 2);
	}

}