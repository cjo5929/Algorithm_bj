import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최대 이동 거리
		int M = Integer.parseInt(br.readLine());
		// 정비소 개수
		int station_num = Integer.parseInt(br.readLine());

		// 정비소 간 거리 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> d = new LinkedList<>();
		for (int i = 0; i < station_num + 1; i++) {
			d.add(Integer.parseInt(st.nextToken()));
		}
		d.add(Integer.MAX_VALUE);

		// 정비 시간 입력
		st = new StringTokenizer(br.readLine());
		LinkedList<Integer> t = new LinkedList<>();
		t.add(0);
		for (int i = 0; i < station_num; i++) {
			t.add(Integer.parseInt(st.nextToken()));
		}
		t.add(0);

		long[] T = new long[station_num + 2];
		int[] P = new int[station_num + 2];
		Arrays.fill(T, Long.MAX_VALUE);
		T[0] = 0;

		for (int i = 0; i <= station_num; i++) {
			int j = i + 1;
			int D = d.get(i);
			while (j <= station_num + 1 && D <= M) {
				if (T[j] > T[i] + t.get(j)) {
					T[j] = T[i] + t.get(j);
					P[j] = i;
				}
				D += d.get(j);
				j++;
			}
		}

		Deque<Integer> result = new LinkedList<>();
		int st_index = P[station_num + 1];
		while (st_index > 0) {
			result.addFirst(st_index);
			st_index = P[st_index];
		}

		System.out.println(T[station_num + 1]);
		if (!result.isEmpty()) {
			System.out.println(result.size());
			for (int station : result) {
				System.out.print(station + " ");
			}
		} else {
			System.out.println(0);
		}
	}
}