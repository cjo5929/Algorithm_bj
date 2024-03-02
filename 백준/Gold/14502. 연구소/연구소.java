import java.awt.Point;
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
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, max_result, area, safe_area;
	static int[][] arr, temp;
	static ArrayList<Point> list_0;
	static ArrayList<Point> list_2;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		temp = new int[N][M];

		list_0 = new ArrayList<Point>();
		list_2 = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 0) {
					list_0.add(new Point(i, j));
				} else if (arr[i][j] == 2) {
					list_2.add(new Point(i, j));
				}else {
					
				}

			}

		}

		comb(0, 0, new Point[3]);
		System.out.println(max_result);

	}

//	벽 3개 설치하는 모든 경우의 수
	static void comb(int depth, int start, Point[] change) {

		if (depth == 3) {

			create(change); // 벽 3개 설치

//			안전영역 계산

			for (Point cur : list_2) {
				dfs(cur.x, cur.y);
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(temp[i][j] + " ");
//
//				}
//				System.out.println();
//			}
//			System.out.println();
//			0의 개수 세기
			area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0)
						area++;
				}

			}
			max_result = Math.max(max_result, area);
			return;
		}

		for (int i = start; i < list_0.size(); i++) {
			change[depth] = list_0.get(i);
			comb(depth + 1, i + 1, change);
		}
	}

//	벽 설치
	static void create(Point[] chage) {
		for (int i = 0; i < N; i++) {
			temp[i] = Arrays.copyOf(arr[i], M);
		}

		for (Point cur : chage) {
			temp[cur.x][cur.y] = 1;
		}
		
	}

//	안전 영역의 최대 크기 출력
	static void dfs(int x, int y) {

		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if (check(ax, ay)) {
				temp[ax][ay] = 2;
				dfs(ax, ay);

			}
		}

		return;
	}

	static boolean check(int ax, int ay) {
		return ax >= 0 && ax < N && ay >= 0 && ay < M && temp[ax][ay] == 0;
	}

}