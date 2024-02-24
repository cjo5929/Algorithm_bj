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
			int now = arr[i];
			if(before == now || isVisited[i]) { // 중복된 수 이거나 이미 방문한 수라면 통과함
				continue;
			} else { // 아직 방문도 하지 않았고 중복된 수도 아니라면
				before = now;
				isVisited[i] = true;
				printArr[depth] = arr[i];
				dfs(i + 1, depth + 1);
				isVisited[i] = false;
			}
		}
	}
}