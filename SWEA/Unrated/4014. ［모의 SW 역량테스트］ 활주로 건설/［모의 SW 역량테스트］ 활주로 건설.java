import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, X, result;
	static int[][] arr1, arr2;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			arr1 = new int[N][N];
			arr2 = new int[N][N];

			result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr1[i][j] = Integer.parseInt(st.nextToken());
					arr2[j][i] = arr1[i][j];

				}
			}

			result += create(arr1);
			result += create(arr2);

			sb.append(result + "\n");

		}
		System.out.println(sb);
	}

	static int create(int[][] arr) {
		int cnt = 0;
//		세로탐색
		for (int i = 0; i < N; i++) {
			boolean flag = true; // 가능한 활주로인지
			visited = new boolean[N]; // 경사로 설치를 했으면 true;
			for (int j = 0; j < N - 1; j++) {

				int num = arr[i][j] - arr[i][j + 1];

				if (num == 0) {
					continue;
				}

//				오른쪽 높이가 1만큼 작을 때
				else if (num == 1) {
					if (possible_1(i, j + 1, arr)) {
						int temp = j;
						j = j + X - 1;
						
//						경사로 표시
						for(int k = temp; k <= j + 1; k++) {
							visited[k] = true;
						}

						continue;
					} else {
						flag = false;
						break;
					}
				}

//				오른쪽 높이가 1만큼 클 때
				else if (num == -1) {
					if (possible_2(i, j, arr)) {
						
//						경사로 표시
						for(int k = (j + 1) - X; k >= j; k--) {
							visited[k] = true;
						}
						continue;
					} else {
						flag = false;
						break;
					}
				}

				flag = false;

			}
			if (flag) {
				cnt++;
			}
		}
		
		
		return cnt;
	}

//	오른쪽 높이가 1만큼 작은 경사로 설치가 가능한지 체크
	static boolean possible_1(int x, int y, int[][] arr) {
		for (int i = y + 1; i < y + X; i++) {
			if (!check(x, i))
				return false;

			if (visited[i])
				return false;

			if (arr[x][i] != arr[x][y])
				return false;
		}

		return true;
	}

//	오른쪽 높이가 1만큼 큰 경사로 설치가 가능한지 체크
	static boolean possible_2(int x, int y, int[][] arr) {
		int index = (y + 1) - X;
		if (index < 0) {
			return false;
		}
		for (int i = y; i >= index; i--) {
			if (!check(x, i))
				return false;

			if (visited[i])
				return false;

			if (arr[x][i] != arr[x][y])
				return false;
		}

		return true;
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < N;
	}

}