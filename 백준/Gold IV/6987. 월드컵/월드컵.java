import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.14
 * @link https://www.acmicpc.net/problem/6987
 * @keyword_solution
 * @input
 * @output
 * @time_complex
 * @perf
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int sum;
	static int[] win, lose, tie;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		win = new int[6];
		lose = new int[6];
		tie = new int[6];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			sum = 0;

			flag = false;

			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				tie[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				sum += win[j];
				sum += tie[j];
				sum += lose[j];

			}
			
			if (sum == 30) {
				dfs(0, 0, 1);
			}
			
			
			if(flag) {
				sb.append(1 + " ");
			}else {
				sb.append(0 + " ");
			}

		}

		System.out.println(sb);

	}
	
	static void dfs(int team, int cnt, int index) {
		
		
		
		if(win[team] < 0 || lose[team] < 0 || tie[team] < 0 || win[team + index - 1] < 0 || lose[team + index - 1] < 0 || tie[team  + index  - 1] < 0) {
			return;
		}
		
		//종료조건
		if(cnt == 15) {
			flag = true;
			return;
		}
		
		
		if(cnt == 5) {
			team++;
			index = 1;
		}else if(cnt == 9) {
			team++;
			index = 1;
		}else if(cnt == 12) {
			team++;
			index = 1;
		}else if(cnt == 14){
			team++;
			index = 1;
		}

		
		
		
		
		// A가 이기고 B가 질때
		win[team]--;
		lose[team + index]--;
		dfs(team, cnt + 1, index + 1);
		win[team]++;
		lose[team + index]++;
		
		// A가 지고 B가 이길때
		win[team + index]--;
		lose[team]--;
		dfs(team, cnt + 1, index + 1);
		win[team + index]++;
		lose[team]++;
		
		//  무승부
		tie[team]--;
		tie[team + index]--;
		dfs(team, cnt + 1, index + 1);
		tie[team]++;
		tie[team + index]++;
	}

}