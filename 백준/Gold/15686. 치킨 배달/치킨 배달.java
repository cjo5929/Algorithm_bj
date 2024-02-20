import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author 강민서
 * @date 2024.02.20
 * @link https://www.acmicpc.net/problem/15686
 * @keyword_solution 도시의 치킨 거리가 가장 작게 될지, 사이의 거리는 |r1-r2| + |c1-c2| => 집과 치킨 사이의
 *                   거리를 계산해서 그 합이 가장 작은 값을 리턴 => 완전탐색(집 위치 저장, 치킨집의 위치는 조합으로 저장
 *                   후 각 집 마다 최솟값 저장)
 * @input N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13), 집의 개수는 2N개를 넘지 않으며 =>조합을 구성해서 완탐일 때 최악일
 *        경우 2^13 X 100
 * @output 최솟값 출력
 * @time_complex O(2^13 X 100)
 * @perf 16824 208
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, result, answer;
	static int[][] arr;
	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (num == 1) {
					home.add(new Point(i, j));
				} else if (num == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		permu(new Point[M], 0, 0);

		System.out.println(answer);
	}

	static void permu(Point[] list, int depth, int start) {
		if (depth == M) {
			result = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				Point h = home.get(i);

				for (Point p : list) {
					min = Math.min(min, dist(h.x, h.y, p.x, p.y));
				}

				result += min;
			}

			answer = Math.min(result, answer);
			return;

		}

		for (int i = start; i < chicken.size(); i++) {
			list[depth] = chicken.get(i);
			permu(list, depth + 1, i + 1);
		}
	}

	static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}