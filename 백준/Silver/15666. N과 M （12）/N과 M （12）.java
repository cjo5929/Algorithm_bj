import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr, printArr;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		printArr = new int[M];
		isVisited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); // 오름차순으로 정렬
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	static void dfs(int start, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(printArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
			int before = -1;
		for(int i=start; i<N; i++) {
			if(before == arr[i]) {
				continue;
			} else { 
				before = arr[i];
				printArr[depth] = arr[i];
				dfs(i, depth + 1);

			}
		}
	}
}