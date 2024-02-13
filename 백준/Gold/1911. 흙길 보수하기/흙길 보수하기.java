import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, L, cnt;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[]o2) {
				if(o1[1] > o2[1]) return 1;
				else if(o1[1] == o2[1]) return 0;
				
				return -1;
			}
			
			
		});
		
		int range = 0;
		for(int[]  pool: arr) {
			if(pool[0] > range) {
				range = pool[0];
			}
			
			while(pool[1] > range) {
				range += L;
				cnt++;
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
		
	}

}