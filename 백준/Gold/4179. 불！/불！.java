import java.awt.Point;

/**
 * @author 
 * @date 
 * @link
 * @keyword_solution  
 * @input 
 * @output   
 * @time_complex  
 * @perf 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C, jihun_x, jihun_y, fire_x, fire_y, result, size;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> fire_q = new ArrayDeque<>();
	static Queue<Point> jihun_q = new ArrayDeque<>();
	static boolean possible;
	static boolean[][] visited;



	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'J') {
                	jihun_q.offer(new Point(i, j));
                    visited[i][j] = true;
                } else if (arr[i][j] == 'F') {
                	fire_q.offer(new Point(i, j));
                }
            }
        }

		bfs();

	}

	static void bfs() {
		int ax = 0;
		int ay = 0;
		int x = 0;
		int y = 0;

//		이동
		while (true) {
			size = fire_q.size();
			result++;
//			불 q
			while (size-- > 0) {
				Point cur = fire_q.poll();
				x = cur.x;
				y = cur.y;

				for (int i = 0; i < 4; i++) {
					ax = x + dx[i];
					ay = y + dy[i];

                    if (ax < 0 || ax >= R || ay < 0 || ay >= C || arr[ax][ay] != '.') {
                        continue;
                    }
                    
                    arr[ax][ay] = 'F';
                    fire_q.add(new Point(ax, ay));
				}

			}

//			지훈이 q
			size = jihun_q.size();

			while (size-- > 0) {
				Point cur = jihun_q.poll();
				x = cur.x;
				y = cur.y;

				for (int i = 0; i < 4; i++) {
					ax = x + dx[i];
					ay = y + dy[i];

                    if (ax < 0 || ax >= R || ay < 0 || ay >= C) {
                        System.out.println(result);
                        return;
                    }

					if (visited[ax][ay] || arr[ax][ay] != '.')
						continue;

					visited[ax][ay] = true;
					jihun_q.add(new Point(ax, ay));

				}

			}

            if (jihun_q.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }

		}

	}

//	static boolean check(int x, int y) {
//		return (x >= 0 && x < R && y >= 0 && y < C);
//	}

}