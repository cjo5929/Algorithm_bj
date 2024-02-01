import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.01
 * @link https://www.acmicpc.net/problem/2023
 * @keyword_solution N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 => 자리수 마다 소수를 거르고 재귀로 호출
 * @input  (1 ≤ |P| ≤ |S| ≤ 1,000,000) => 부분문자열을 만들기에는 너무 큼(2^1,000,000)
 * @output 비밀번호의 종류의 수를 출력 -> int형 가능
 * @time_complex 
 * @perf 
 */


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int S, P, cnt;
	static int[] rule = new int[4];
	static int[] input = new int[4];
	static char[] str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		str = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			rule[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < P; i++) {
			if(str[i] == 'A') input[0]++;
			if(str[i] == 'C') input[1]++;
			if(str[i] == 'G') input[2]++;
			if(str[i] == 'T') input[3]++;
		}
		
		if(check()) cnt++;
		
		int i = 0;
		for (int j = P; j < S; j++) { // 부분문자열의 끝을 나타내는 위치
			i = j - P; // 이전 부분문자열의 시작을 나타내는 위치
			
			// 이전 부분문자열의 시작 문자 제외
			if (str[i]=='A') input[0]--;
			if (str[i]=='C') input[1]--;
			if (str[i]=='G') input[2]--;
			if (str[i]=='T') input[3]--;
			
			// 이전 부분문자열의 끝에서 1문자 추가
			if (str[j]=='A') input[0]++;
			if (str[j]=='C') input[1]++;
			if (str[j]=='G') input[2]++;
			if (str[j]=='T') input[3]++;
			
			if (check())// {‘A’, ‘C’, ‘G’, ‘T’} 4개의 문자가 모두 최소개수를 만족했다면
				cnt++; // 만들 수 있는 비밀번호 개수 증가
		}
		
		sb.append(cnt);
		System.out.println(sb);
		


		
	}
	
	static boolean check() {
		for(int i = 0; i < 4; i++) {
			if(input[i] < rule[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	

}