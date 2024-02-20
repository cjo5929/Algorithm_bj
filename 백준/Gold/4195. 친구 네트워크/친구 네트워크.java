import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, F;
	static Map<String, Integer> friend;
	static int[] parent, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			F = Integer.parseInt(br.readLine());
			
			parent = new int[F * 2];  // 이름을 인덱스 형태로 저장
			count = new int[F * 2];   // 연결되는 친구 수를 저장 
			friend = new HashMap<>();
			
//			본인으로 초기화 
//			친구 수 또한 1로 초기화
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				count[i] = 1;
			}

			int index = 0;
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

//				map에 이름과 indes번호 담기 
				if (!friend.containsKey(a)) {
					friend.put(a, index++);
				}

				if (!friend.containsKey(b)) {
					friend.put(b, index++);
				}

				sb.append(union(friend.get(a), friend.get(b))).append("\n");

			}
		}

		System.out.println(sb);

	}

//	find 연산 헤드 찾기 
	static int find(int x) {
		if (x == parent[x])
			return x;

		return find(parent[x]);
	}

// unoin 연산 => 같은 헤드를 바라보게 
	static int union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
			count[x] += count[y];

		}

		return count[x];

	}

}