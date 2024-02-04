import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 강민서
 * @date 2024.02.04
 * @link https://www.acmicpc.net/problem/1941
 * @keyword_solution 조건 1. 7명의 여학생들로 구성되어야 한다. 조건 2. 7명의 자리는 서로 가로나 세로로 반드시 인접해
 *                   있어야 한다. 조건 3. 'S'(이다‘솜’파의 학생을 나타냄) => 적어도 4명 이상 => dfs로 배열을
 *                   다 탐색 할 수도 있지만 탐색 할 경우의 수가 너무 많음... 코드 작성하기가 어렵다 => 5x5 배열에서
 *                   7자리를 찾는 것 이기 때문에 순서가 무의미 한 조합으로 7개를 뽑고 그 이후에 조건 판단하자
 * @input 5 x 5 행렬이 주어짐
 * @output 경우의 수 출력 -> 출력 값 int
 * @time_complex O(2^25)
 * @perf 73728 480
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] arr;
	static int[] arrX;
	static int[] arrY;
	static boolean[] visitied;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int result;
	
	public static void main(String[] args) throws Exception {

		arr = new char[5][5];

		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();

		}
		arrX = new int[25];
		arrY = new int[25];
		
		
//		좌표 생성 => 0 ~ 24 를 2차원 배열 좌표로
		for(int i = 0; i < 25; i++) {
			arrX[i] = i / 5;
			arrY[i] = i % 5;
		}

		result = 0;
		
//		조합 생성 => 0 ~ 24 숫자 중 7가지 뽑기
		combination(new int[7], 0, 0);
		
		sb.append(result);
		System.out.println(sb);

	}

	

	static void combination(int[] comb, int depth, int start) {
		if (depth == 7) {
			bfs(comb);
			return;
		}

		for (int i = start; i < 25; i++) {
			comb[depth] = i;
			combination(comb, depth + 1, i + 1);
		}

	}

	static void bfs(int[] comb) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		visitied = new boolean[7];
		
		q.add(comb[0]);
		visitied[0] = true;
		int leng = 1;
		int cnt = 0;
		
		

		while(!q.isEmpty()) {
			int temp = q.poll();
			
//			S 카운트
			if(arr[arrX[temp]][arrY[temp]] == 'S') cnt++;
			
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j < 7; j++) {
					
//					1. 뽑힌 7개 숫자가 연결 된 좌표에 있는지
					if(arrX[temp] + dx[i] == arrX[comb[j]] && arrY[temp] + dy[i] ==  arrY[comb[j]] && !visitied[j]) {
						leng++;
						visitied[j] = true;
						q.add(comb[j]);
					}
					
				}
				
			}
			
		}
		
//		7개가 인접하고 S가 4개 이상일 때
		if(leng == 7 && cnt >= 4) {
			result++;
		}
		
		
	}


}