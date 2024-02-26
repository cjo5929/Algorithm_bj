import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static Stack<Point> stack = new Stack<>();
	static int N, M, cnt, sum, a, b, c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int time = 0;

		while (time++ < N) {
			st = new StringTokenizer(br.readLine());
			a = 0;

			if (st.hasMoreTokens()) {
				a = Integer.parseInt(st.nextToken());
			}

			if (a == 1) {
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				stack.push(new Point(b, c));
			}

			if (!stack.isEmpty()) {

				stack.peek().y--;

				if (stack.peek().y == 0) {
					sum += stack.peek().x;
					stack.pop();
				}

			}

		}
		System.out.println(sum);

	}

}