import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, -1, -1 }; // 왼쪽 가운데 오른쪽
	static int[] dy = { -1, 0, 1 };
	static int N, M, D, sum_result, result;
	static int[][] arr, temp;
	static boolean game_over;
	static int[] archer;
	static List<int[]> list;

	static class Monster implements Comparable<Monster> {
		int x, y, d; // 행, 열, 거리

		public Monster(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Monster o) {
			if (this.d == o.d) {
				return this.y - o.y;
			} else {
				return this.d - o.d;
			}

		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		archer = new int[3];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					list.add(new int[] { i, j });
				}
			}
		}

		comb(0, 0);

		System.out.println(sum_result);

	}

	static void comb(int depth, int start) {
		if (depth == 3) {
			List<int[]> data = copy(list);
			attack(data);
			return;
		}

		for (int i = start; i < M; i++) {
			archer[depth] = i;
			comb(depth + 1, i + 1);
		}
	}

//  몬스터 좌표 리스트 복사
	static List<int[]> copy(List<int[]> list) {
		List<int[]> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int[] cur = list.get(i);
			temp.add(new int[] { cur[0], cur[1] });
		}

		return temp;
	}

//	공격
	static void attack(List<int[]> list) {
		result = 0; // 공격한 몬스터 수 초기화

		while (true) {
			if (list.isEmpty())
				break;
			List<int[]> targets = new ArrayList<>(); // 이번 공격에 공격 할 적의 좌표

			for (int i = 0; i < 3; i++) {
				PriorityQueue<Monster> q = new PriorityQueue<>();

				for (int a = 0; a < list.size(); a++) {
					int[] cur = list.get(a);
					int d = Math.abs(cur[0] - N) + Math.abs(cur[1] - archer[i]);
					if (d <= D) {
						q.add(new Monster(cur[0], cur[1], d));
					}
				}

				if (!q.isEmpty()) {
					Monster target = q.poll();

					boolean flag = false;
					for (int j = 0; j < targets.size(); j++) {
						int[] cur2 = targets.get(j);
						if (target.x == cur2[0] && target.y == cur2[1]) { // 이미 누군가가 잡음
							flag = true;
						}
					}

					if (!flag) {
						targets.add(new int[] { target.x, target.y });
					}

				}

			}

			for (int a = 0; a < targets.size(); a++) {
				for (int b = list.size() - 1; b >= 0; b--) {
					if (targets.get(a)[0] == list.get(b)[0] && targets.get(a)[1] == list.get(b)[1]) {
						list.remove(b);
						result++;
						break;
					}
				}
			}

//			몬스터 이동
			for (int i = list.size() - 1; i >= 0; i--) {
				list.get(i)[0] += 1;
				if (list.get(i)[0] == N)
					list.remove(i);
			}

		}

		sum_result = Math.max(result, sum_result);
	}

}