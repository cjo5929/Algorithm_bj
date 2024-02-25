import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, result;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Line> q = new PriorityQueue<>();

	static class Line implements Comparable<Line> {
		int x, y;

		public Line(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Line o) {
			if (this.x == o.x)
				return Integer.compare(this.y, o.y);

			return Integer.compare(this.x, o.x);
		}

		@Override
		public String toString() {
			return "Line [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			q.offer(new Line(s, e));
		}

		Line first = q.poll();
		int cur_x = first.x;
		int cur_y = first.y;
		result = cur_y - cur_x;
		
		while(!q.isEmpty()) {
			Line next = q.poll();
			
			if(next.x <= cur_y) {
				if(next.y > cur_y) {
					result += next.y - cur_y;
					cur_y = next.y;
					
				}
			}else {
				cur_x = next.x;
				cur_y = next.y;
				result += cur_y - cur_x;		
			}
			
		}
		
		System.out.println(result);

	}

}