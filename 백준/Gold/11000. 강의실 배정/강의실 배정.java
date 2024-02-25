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
		
//		시작시간을 기준으로 정렬, 같다면 종료시간 오름차순
		Arrays.sort(arr);  
		
		
//		끝나는 시간만 넣어서 오름차순 정렬
		q.offer(arr[0].end);

		for(int i = 1; i < N; i++) {
			
//			가능한 수업이라면 q에서 poll
			if(q.peek() <= arr[i].start) {
				q.poll();
			}
			
//			새롭게 갱신
			q.offer(arr[i].end);
		}
		
		
		System.out.println(q.size());

	}

}