/**
 * @author 강민서
 * @date 2024.02.15
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV5LyE7KD2ADFAXc&solveclubId=AY0LFFoqrIIDFAXz&problemBoxTitle=0212%EC%A3%BC&problemBoxCnt=5&probBoxId=AY2gBgM6OSIDFAXh
 * @keyword_solution  주어진 조건에 맞게 탱크를 움직여야함 -> 시뮬레이션 
 * @input  H, W (2 ≤ H, W ≤ 20) => 입력값은 크지 않아서 시간 걱정은 X
 * @output 변화된 배열 출력 
 * @time_complex  21,916 kb 141 ms
 * @perf O(N)
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, H, W, N, x, y, dist;
	static int[] dx = { -1, 1, 0, 0 }; // 상하 좌우 순서
	static int[] dy = { 0, 0, -1, 1 };
	static boolean visited;
	static char[][] maps;
	static char[] command;
	static ArrayList<Character> tank = new ArrayList<>(Arrays.asList('^', 'v', '<', '>'));
	static Map<Character, Integer> command_dict = new HashMap<>(); // 
	static Map<Integer, Character> arrowd_dict = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		command_dict.put('U', 0);
		command_dict.put('D', 1);
		command_dict.put('L', 2);
		command_dict.put('R', 3);
		command_dict.put('^', 0);
		command_dict.put('v', 1);
		command_dict.put('<', 2);
		command_dict.put('>', 3);

		arrowd_dict.put(0, '^');
		arrowd_dict.put(1, 'v');
		arrowd_dict.put(2, '<');
		arrowd_dict.put(3, '>');

//		입력 값 받기
//		#########################################

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			maps = new char[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				maps[i] = st.nextToken().toCharArray();
				for (int j = 0; j < W; j++) {
					if (tank.contains(maps[i][j])) {
						x = i;
						y = j;
					}
				}

			}

			N = Integer.parseInt(br.readLine());
			command = new char[N];

			command = br.readLine().toCharArray();
//      #########################################

			for (int i = 0; i < N; i++) {

//			포탄 발사
				if (command[i] == 'S') {
					int cx = x;
					int cy = y;

					dist = command_dict.get(maps[cx][cy]);

					while (true) {
						int ax = cx + dx[dist];
						int ay = cy + dy[dist];

						if (!check(ax, ay) || maps[ax][ay] == '#')
							break;
						else if (maps[ax][ay] == '*') {
							maps[ax][ay] = '.';
							break;
						}

						cx = ax;
						cy = ay;

					}

				}

//			탱크 이동
				else {
					int dist = command_dict.get(command[i]);
					int ax = 0;
					int ay = 0;
					while (true) {
						ax = x + dx[dist];
						ay = y + dy[dist];

						if (check(ax, ay) && maps[ax][ay] == '.') {
							maps[x][y] = '.';
							x = ax;
							y = ay;
							maps[x][y] = arrowd_dict.get(dist);

						}

						maps[x][y] = arrowd_dict.get(dist);
						break;

					}

				}

			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(maps[i][j]);
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);
	}

	static boolean check(int ax, int ay) {
		if (ax >= 0 && ax < H && ay >= 0 && ay < W)
			return true;

		return false;
	}

}