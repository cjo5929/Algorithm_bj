import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, q, k, idx, result;
	static boolean re_flag;
	static ArrayList<Work> list;
	static PriorityQueue<Work> pq;
	static ArrayDeque<Work> stack;

	static class Work implements Comparable<Work> {
		int idx, com, num;

		public Work(int idx, int com, int num) {
			this.idx = idx;
			this.com = com;
			this.num = num;
		}

		@Override
		public int compareTo(Work o) {
			return Integer.compare(o.num, this.num);
		}

		@Override
		public String toString() {
			return "Work [idx=" + idx + ", com=" + com + ", num=" + num + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		pq = new PriorityQueue<>();
		stack = new ArrayDeque<>();

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (a == 0) {
				list.add(new Work(i, 0, Integer.parseInt(st.nextToken())));
			} else if (a == 1) {
				idx = i; // 마지막 나온 1 번호 저장
				list.add(new Work(i, 1, 0));

			} else {
				list.add(new Work(i, 2, 0));
			}
		}

		for (int i = 0; i < idx; i++) {
			if(list.get(i).com == 0) {
				pq.offer(list.get(i));
			}
		}

		while (!pq.isEmpty()) {
			stack.push(pq.poll());
		}
		// false = stack, true = q

		for (int i = idx; i < q; i++) {

			if (list.get(i).com == 0) {
				if (re_flag) {
					stack.addLast(list.get(i));
				} else {
					stack.addFirst(list.get(i));
				}
			} else if(list.get(i).com == 2) {
				re_flag = re_flag ? false : true;
			}
		}


		
		for (int i = 1; i < k; i++) {
			if (re_flag) {
				result = stack.pollLast().num;
			} else {
				result = stack.pollFirst().num;
			}
		}
		
		
		if (re_flag) {
			System.out.println(stack.pollLast().num);
		}else {
			System.out.println(stack.pollFirst().num);
		}
		
		

	}

}