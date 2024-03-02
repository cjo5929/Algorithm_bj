import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, C, result, power_result;
	static int[][] arr;
	static int[] honey;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			honey = new int[2]; // honey[0] = A, honey[1] = B
			result = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			입력 확인
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}

			comb(0, 0);
			sb.append(result + "\n");

		}
		System.out.println(sb);
	}

//	벌꿀 채집 조합
	static void comb(int depth, int start) {
		if (depth == 2) {

//			다른 행일경우
			if (honey[0] / N != (honey[0] + (M - 1)) / N)
				return;
			if (honey[1] / N != (honey[1] + (M - 1)) / N)
				return;

//			같은 행에서 겹칠 경우
			if (honey[0] + (M - 1) >= honey[1])
				return;

			int sum = honey_calc(honey[0], honey[1]);

			result = Math.max(result, sum);
			return;
		}

		for (int i = start; i < N * N; i++) {
			honey[depth] = i;
			comb(depth + 1, i + 1);
		}

	}

//	벌꿀 수익 계산
	static int honey_calc(int A_start, int B_start) {
		ArrayList<Integer> list = new ArrayList<>();
//		A
		int i_start = (A_start / N);
		int j_start = (A_start % N);

		for (int j = j_start; j < j_start + M; j++) {
			list.add(arr[i_start][j]);
		}

		int A_sum = calc(list);

		list.clear();
//		B
		i_start = (B_start / N);
		j_start = (B_start % N);

		for (int j = j_start; j < j_start + M; j++) {
			list.add(arr[i_start][j]);
		}

		int B_sum = calc(list);

		return A_sum + B_sum;
	}

//	수익 계산
	static int calc(ArrayList<Integer> list) {

		power_result = Integer.MIN_VALUE;

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2) * -1;
			}
		});
		

		honey_power(new boolean[list.size()], 0, list);	
		
		return power_result;
	}
	
//	최대 수익 계산
	static void honey_power(boolean[] checked, int depth, ArrayList<Integer> list) {
		
		if(depth == list.size()) {
			int sum = 0;
			int all_sum = 0;
			for(int i = 0; i < list.size(); i++) {
				if(checked[i]) {
					all_sum += list.get(i);
					if(all_sum > C)return;
					sum += (list.get(i) * list.get(i));
				}
			}
			
			power_result = Math.max(sum, power_result);
			
			return;
		}
		
		checked[depth] = true;
		honey_power(checked, depth + 1, list);
		checked[depth] = false;
		honey_power(checked, depth + 1, list);
	}

}