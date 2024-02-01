import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.01
 * @link https://www.acmicpc.net/problem/2023
 * @keyword_solution N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 => 자리수 마다 소수를 거르고 재귀로 호출
 * @input N(1 ≤ N ≤ 8) => 완탐도 가능할 것 같음
 * @output 소수인 수를 한 줄씩 출력 => 시간은 신경 x
 * @time_complex O(10^n)
 * @perf 14176	848
 */


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		
		makeSosu(N, 0);
		System.out.println(sb);
		
		

	}
	
	static void makeSosu(int n, int num) { // n은 자릿수 업데이트, num: 소수넘겨주기
		if(n == 0) {
			sb.append(num).append("\n");
			return;
		}
		
		
		for(int i = 0; i < 10; i++) {
			
			int answer = num * 10 + i;
			if(check(answer)) { // 소수이면 재귀 호출
				makeSosu(n - 1, answer); 
			}
			
		}
	}
	
//	소수 판별
	static boolean check(int num) {
		if(num < 2) return false;
		
		for(int i = 2; i < Math.abs(num); i++) {
			if(num % i == 0) return false;
		}
		
		
		return true;
	}

}