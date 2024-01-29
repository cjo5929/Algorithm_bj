import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 강민서
 * @date 0129
 * @link https://www.acmicpc.net/problem/1914
 * @keyword_solution
 * @input 3
 * @output "7 1 3 1 2 3 2 1 3 2 1 2 3 1 3"
 * @time_complex
 * @perf
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		BigInteger cnt = new BigInteger("2");
		sb.append(cnt.pow(n).subtract(new BigInteger("1"))).append("\n");
		
		if(n <= 20) {
			hanoi(n, 1, 2, 3);
		}
		System.out.println(sb);
	}

	static void hanoi(int n, int start, int mid, int end) {
		if (n == 0) {
			return;
		}
		
//		n-1(마지막 원반을 제외한) 원반을 중간을 옮김
		hanoi(n - 1, start, end, mid);
//		마지막 원반을 끝으로 옮김 출력 
		sb.append(start).append(" ").append(end).append("\n");
//		나머지 원반을 마지막으로 옮김
		hanoi(n - 1, mid, start, end);
		
	}
}