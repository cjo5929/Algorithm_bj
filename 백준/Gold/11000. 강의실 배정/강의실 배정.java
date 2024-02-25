import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, result;
	static Lesson[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> q = new PriorityQueue<>();

	static class Lesson implements Comparable<Lesson> {
		int start, end;

		public Lesson(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lesson o) {
			if (this.start == o.start)
				return Integer.compare(this.end, o.end);

			return Integer.compare(this.start, o.start);
		}

		@Override
		public String toString() {
			return "Lesson [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		arr = new Lesson[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[i] = new Lesson(s, e);
		}
		
		Arrays.sort(arr);
		q.offer(arr[0].end);

		for(int i = 1; i < N; i++) {
			
			if(q.peek() <= arr[i].start) {
				q.poll();
			}
			
			q.offer(arr[i].end);
		}
		
		
		System.out.println(q.size());

	}

}