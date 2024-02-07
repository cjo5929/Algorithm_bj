/**
 * @author 강민서
 * @date 2024.02.07
 * @link https://www.acmicpc.net/problem/2563
 * @keyword_solution  여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램 => 겹치는 구간을 잘 파악해야함
 * => 색종이의 영역을 boolean으로 체크하면 중복이 되는 곳을 넘어 갈 수 있음 -> 넓이는 중복이 안 되는 곳이 들어오면 1씩 더 해주기
 * EX) 10 X 10 색종이의 넓이는 100, 2차원 배열에서 색종이의 왼쪽 끝 부터 오른쪽 끝 까지 돌면서 +1 씩 더해주면 100
 * @input 2차원 배열의 크기는 100 X 100 고정, 색종이의 수는 100 이하이며, =>완탐을 해도 O(N^3) => N이 최고로 커봤자 100
 * @output 넓이 출력 
 * @time_complex  O(N^3)
 * @perf 14244	124
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, area;
	static boolean[][] paper = new boolean[101][101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
//			색종이의 좌표를 입력 받을 때 마다 2차원 배열을 돌면서 체크(색종이 크기만큼)
			for(int j = y; j < y + 10; j++) {
				for(int k = x; k < x + 10; k++) {
					if(!paper[j][k]) { // 종이가 중복된 부분 체크
						paper[j][k] =true;
						area++;  //넓이 증가
					}
				}
			}
			
		}
		System.out.println(area);

	}

}