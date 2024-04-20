import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, t, cnt;
	static ArrayDeque<Point> q;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		list = new ArrayList[200001];

		for (int i = 0; i < 200001; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[y].add(x);
		}
		
		for (int i = 0; i < 200001; i++) {
			Collections.sort(list[i]);
		}
		
		bfs();

	}

	static void bfs() {
		q = new ArrayDeque<>();
		q.offer(new Point(0, 0));
		int size = 0;

		while (!q.isEmpty()) {
			size = q.size();
			cnt++;
			while (size-- > 0) {
				Point cur = q.poll();

				move(cur.x, cur.y);
			}

		}

		System.out.println(-1);

	}

	static void move(int x, int y) {

		for (int i = y - 2; i <= y + 2; i++) {
			if(i < 0 || i > 200000) continue;
			for (int j = 0; j < list[i].size(); j++) {
				int cur_x = list[i].get(j);
				if(x + 2 < cur_x) break;
				else if(x - 2 > cur_x) continue;
				
				if(i == t) {
					System.out.println(cnt);
					System.exit(0);
				}
				
				q.add(new Point(list[i].get(j), i));
				list[i].remove(j);
				j--;
			}
		}

	}

}