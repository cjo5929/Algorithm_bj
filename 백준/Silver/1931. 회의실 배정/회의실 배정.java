import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, turn;
	static Meeting[] meetings;
	static List<Meeting> list = new ArrayList<>();

	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Meeting o) {
			if (this.end != o.end) {
				return this.end - o.end;
			} else {
				return this.start - o.start;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);

		}

		Arrays.sort(meetings);

//		회의 선택을 최대로 하고 선택된 회의들의 내용을 출력
		list.add(meetings[0]);
		for (int i = 1; i < N; i++) {
			if (list.get(list.size() - 1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		
		sb.append(list.size());
		System.out.println(sb);
	}

}