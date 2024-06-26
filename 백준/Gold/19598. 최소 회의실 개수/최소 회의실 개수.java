import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, result;
	static Meeting[] arr;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();


	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.start == o.start) {
				return Integer.compare(this.end, o.end);
			}

			return Integer.compare(this.start, o.start);
		}
	}

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new Meeting[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i] = new Meeting(a, b);
		}

		Arrays.sort(arr);

		pq.offer(arr[0].end);

		for (int i = 1; i < n; i++) {

			if(pq.peek() <= arr[i].start){
				pq.poll();
			}

			pq.offer(arr[i].end);

		}

		System.out.println(pq.size());
	}

}